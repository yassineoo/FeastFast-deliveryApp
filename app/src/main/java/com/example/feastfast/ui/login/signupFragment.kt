package com.example.feastfast.ui.login

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.feastfast.R
import com.example.feastfast.databinding.FragmentSignupBinding
import com.example.feastfast.models.RegisterRequest
import com.example.feastfast.models.User
import com.example.feastfast.models.retrofit.Endpoint
import kotlinx.coroutines.*
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.net.URI.create


class signupFragment : Fragment() {
    var binding : FragmentSignupBinding? = null

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var fullNameEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var registerButton: Button

    private val pickImage = 100
    private val REQUEST_IMAGE_CAPTURE = 0
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater,container,false)
        val view = binding!!.root


        // Inflate the layout for this fragment
        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            binding!!.profilePicture.setImageURI(imageUri)
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding!!.profilePicture.setImageBitmap(imageBitmap)
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Initialize views
        emailEditText = binding!!.emailAdressInput
        passwordEditText = binding!!.password
        fullNameEditText = binding!!.editTextTextPersonName
        phoneNumberEditText = binding!!.editTextPhone2
        registerButton = binding!!.registerBtn
        binding!!.addPhotoIcon.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        binding!!.showHidePassword.setOnClickListener {

            if ( binding!!.password.transformationMethod == PasswordTransformationMethod.getInstance()) {
                // Show password
                binding!!.showHidePassword.setImageResource(R.drawable.icon_open_eye_password)

                binding!!.password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                binding!!.showHidePassword.setImageResource(R.drawable.baseline_hide_source_24)

                // Hide password
                binding!!.password.transformationMethod = PasswordTransformationMethod.getInstance()
            }

        }
        binding!!.takePhoto.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                val captureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(captureIntent, REQUEST_IMAGE_CAPTURE)
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CAMERA),
                    REQUEST_IMAGE_CAPTURE
                )
            }
        }


/*


        // Register button click listener
        registerButton.setOnClickListener {
           // val photoFile = File(imageUri)
           // val photoBase64 = convertFileToBase64(photoFile)

            // Perform registration
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val fullName = fullNameEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()


            // Validate inputs
            if (email.isEmpty() || password.isEmpty() || fullName.isEmpty() || phoneNumber.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {

                val registerRequest = RegisterRequest(fullName, email,phoneNumber, password ,"Native")

                // Call your registration API endpoint here and handle the response


                val exceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
                    requireActivity().runOnUiThread {
                        Toast.makeText(requireActivity(), "register request successful with Some unspecified error", Toast.LENGTH_SHORT).show()
                    }
                }
                CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
                    val response = Endpoint.createEndpoint().register(registerRequest)
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful && response.body() != null) {
                             val data = response.body()!! as User
                            Toast.makeText(requireActivity(), " hi done " + data.name, Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(requireActivity(), "register Request unsuccessful!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                // You can show a loading indicator or disable the button during the registration process

                // Example code to show a success message
                Toast.makeText(requireContext(), "Registration successful", Toast.LENGTH_SHORT).show()

                // Example code to navigate to the login screen after successful registration

            }
        }
*/


        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val fullName = fullNameEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()

            if (email.isEmpty() || password.isEmpty() || fullName.isEmpty() || phoneNumber.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {

                val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
                    requireActivity().runOnUiThread {
                        Toast.makeText(requireActivity(), "register request successful with Some unspecified error", Toast.LENGTH_SHORT).show()
                    }
                }

                CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                    // create request body for image file
                    val file = File(imageUri?.path) // get File from imageUri
                    val fileReqBody = file.asRequestBody("image/*".toMediaTypeOrNull()) // create RequestBody instance

                    // create MultipartBody.Part using file request-body,file name and part name
                    val part = MultipartBody.Part.createFormData("image", file.name, fileReqBody)

                    // create RequestBody for other required parts
                    val fullNamePart = RequestBody.create(MultipartBody.FORM, fullName)
                    val emailPart = RequestBody.create(MultipartBody.FORM, email)
                    val phoneNumberPart = RequestBody.create(MultipartBody.FORM, phoneNumber)
                    val passwordPart = RequestBody.create(MultipartBody.FORM, password)
                    val typePart = RequestBody.create(MultipartBody.FORM, "Native")
                    val registerRequest = RegisterRequest(fullNamePart, emailPart, phoneNumberPart, passwordPart, typePart,part)

                    val response = Endpoint.createEndpoint().register( registerRequest)

                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful && response.body() != null) {
                            val data = response.body()!! as User
                            Toast.makeText(requireActivity(), " hi done " + data.name, Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(requireActivity(), "register Request unsuccessful!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Toast.makeText(requireContext(), "Registration successful", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



/*




*/