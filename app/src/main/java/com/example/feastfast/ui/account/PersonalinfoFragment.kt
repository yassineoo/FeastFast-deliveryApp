package com.example.feastfast.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.feastfast.databinding.FragmentPersonalinfoBinding
import com.example.feastfast.models.EditProfileRequest
import com.example.feastfast.models.User
import com.example.feastfast.models.retrofit.Endpoint
import kotlinx.coroutines.*

class personalinfoFragment : Fragment() {
    var binding : FragmentPersonalinfoBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalinfoBinding.inflate(inflater, container, false)
        val view = binding!!.root


        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  val pref = PreferenceManager.getDefaultSharedPreferences(requireActivity() );
        val pref = requireActivity().getSharedPreferences("fileName", Context.MODE_PRIVATE)

        binding!!.userName2.setText(pref.getString("name","not specified "))
        binding!!.emailAdress.setText(pref.getString("email","not specified "))
        binding!!.userPhone.setText(pref.getString("phone","not specified "))
        val idUser = pref.getInt("idUser",0)
        binding!!.saveChanges.setOnClickListener {

            editProfile(idUser, binding!!.userName2.text.toString() ,binding!!.emailAdress.text.toString(), binding!!.userPhone.text.toString(), binding!!.password2.text.toString() )
        }
    }

    private fun editProfile (id:Int ,name :String ,email :String,phone:String, pass: String ) {

         val editProfileRequest = EditProfileRequest(id, name, email, phone, pass)
        // Call your registration API endpoint here and handle the response


        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            requireActivity().runOnUiThread {
                val errorMessage = "Error occurred: ${throwable.localizedMessage}"
                Toast.makeText(requireActivity(), errorMessage, Toast.LENGTH_LONG).show()
            }
        }


        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = Endpoint.createEndpoint().editProfile(editProfileRequest)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!! as User
                    Toast.makeText(requireActivity(), " hi done " + data.name, Toast.LENGTH_SHORT)
                        .show()
                    //  val sharedPreferences = context.getSharedPreferences("MyPrefs", requireActivity().PR)

                    // save the token
                    //  val pref = PreferenceManager.getDefaultSharedPreferences(requireActivity() );
                    val pref =
                        requireActivity().getSharedPreferences("fileName", Context.MODE_PRIVATE)
                    pref.edit {
                        putString("name", data.name)
                        putString("email", data.email)
                        putString("phone", data.phone_number)
                    }

                    //   val intent = Intent(requireActivity() ,MainActivity::class.java)
                    //     intent.putExtra("user", data) // Pass the Restaurant object as an extra
                    //  requireActivity().startActivity(intent)

                } else {
                    Toast.makeText(
                        requireActivity(),
                        "login Request unsuccessful!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }
}