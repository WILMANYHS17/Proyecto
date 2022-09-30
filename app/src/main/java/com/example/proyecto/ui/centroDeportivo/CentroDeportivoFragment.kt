package com.example.proyecto.ui.centroDeportivo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.R

class CentroDeportivoFragment : Fragment() {

    companion object {
        fun newInstance() = CentroDeportivoFragment()
    }

    private lateinit var viewModel: CentroDeportivoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_centro_deportivo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CentroDeportivoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}