package com.example.proyecto.viewmodel.ui.inicio

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.R
import com.example.proyecto.databinding.FragmentInicioBinding
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

class InicioFragment : Fragment() {

    companion object {
        fun newInstance() = InicioFragment()
    }

    private lateinit var viewModel: InicioViewModel

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inicioViewModel = ViewModelProvider(this).get(InicioViewModel::class.java)
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.
    }

    override fun onDestroyView() {
        super.onDestroyView()
    _binding = null
    }





}