package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inicio.setOnClickListener { inicioSesion() }
        binding.registerUser.setOnClickListener { regitrarUser() }
        binding.registerAdmin.setOnClickListener { registroAdmin() }
    }



    fun inicioSesion(){
        if(binding.usuario.text?.isNotEmpty() == true && binding.contrasena.text?.isNotEmpty() == true){
            val intent = Intent(this,NavegadorUsuario::class.java)
            startActivity(intent)
        }else{
            completarCampos()
        }
    }

    fun completarCampos(){
        Toast.makeText(this,"Llene todos los campos", Toast.LENGTH_SHORT).show()
    }

    fun regitrarUser(){

        val intent = Intent(this, RegistroUsuario::class.java)
        startActivity(intent)
    }

    fun registroAdmin(){

        val intent=Intent(this, RegistroAdministrador::class.java)
        startActivity(intent)
    }


}