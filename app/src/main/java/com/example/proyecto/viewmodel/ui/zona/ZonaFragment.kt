package com.example.proyecto.viewmodel.ui.zona

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.R

class ZonaFragment : Fragment() {

    companion object {
        fun newInstance() = ZonaFragment()
    }

    private lateinit var viewModel: ZonaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_zona, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ZonaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}