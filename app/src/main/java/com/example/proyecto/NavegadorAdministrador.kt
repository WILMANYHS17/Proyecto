package com.example.proyecto

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto.databinding.ActivityNavegadorAdministradorBinding

class NavegadorAdministrador : AppCompatActivity() {

    private lateinit var binding: ActivityNavegadorAdministradorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavegadorAdministradorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView1

        val navController =
            findNavController(R.id.nav_host_fragment_activity_navegador_administrador)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_administrador, R.id.navigation_canchas, R.id.navigation_centroDeportivo, R.id.navigation_inicioAdmin, R.id.navigation_reservasAdmin
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}