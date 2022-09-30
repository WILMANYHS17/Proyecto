package com.example.proyecto

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.IntentReceiverLeakedViolation
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import com.example.proyecto.R
import com.example.proyecto.databinding.ActivityRegistroUsuarioBinding
import kotlinx.coroutines.Dispatchers
import java.util.jar.Manifest

class RegistroUsuario : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegisterUser.setOnClickListener { registrarUsuario() }
        binding.buttonCancelRegisterUser.setOnClickListener { cancelarRegistro() }
        binding.buttonImageUser.setOnClickListener { permisosImagen() }

    }

    fun registrarUsuario() {
        if(binding.nameUser.text?.isNotEmpty()  == true && binding.userUser.text?.isNotEmpty() == true
            && binding.emailUser.text?.isNotEmpty() == true && binding.celUser.text?.isNotEmpty() == true
            && binding.passwordUser.text?.isNotEmpty() == true && binding.ageUser.text?.isNotEmpty() == true){
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Llene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun cancelarRegistro(){

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun permisosImagen(){
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
            binding.imageUser.setImageURI(data)
        }


    }
    fun cargarImagen(){
        val intent= Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityResultGallery.launch(intent)
    }


}