package com.example.proyecto

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.proyecto.R
import com.example.proyecto.databinding.ActivityRegistroAdministradorBinding

class RegistroAdministrador : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroAdministradorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroAdministradorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegisterAdmin.setOnClickListener { registrarAdmin() }
        binding.buttonImage.setOnClickListener { permisisAdminImagen() }
        binding.cancelRegisterAdmin.setOnClickListener { cancelarRegistroAdmin() }
    }

    fun registrarAdmin(){
        if(binding.nameAdmin.text?.isNotEmpty()  == true && binding.userAdmin.text?.isNotEmpty() == true
            && binding.emailAdmin.text?.isNotEmpty() == true && binding.celAdmin.text?.isNotEmpty() == true
            && binding.passwordAdmin.text?.isNotEmpty() == true && binding.ageAdmin.text?.isNotEmpty() == true
            && binding.idAdmin.text?.isNotEmpty() == true){
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Llene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun permisisAdminImagen(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when{
                ContextCompat.checkSelfPermission(
                    this, android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    cargarImagen()
                }
                else->requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }


        }else{

            cargarImagen()
        }
        var intent = Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/")


    }
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted ->
        if(isGranted){
            cargarImagen()
        }else{
            Toast.makeText(this, "Habilitar permisos para continuar", Toast.LENGTH_SHORT).show()
        }

    }
    private val startActivityResultGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        if(result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data
            binding.imageAdmin.setImageURI(data)
        }


    }
    fun cargarImagen(){
        val intent= Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityResultGallery.launch(intent)
    }

    fun cancelarRegistroAdmin(){

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}