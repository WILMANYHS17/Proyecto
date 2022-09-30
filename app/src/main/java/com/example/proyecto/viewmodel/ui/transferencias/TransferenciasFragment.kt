package com.example.proyecto.viewmodel.ui.transferencias

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.R

class TransferenciasFragment : Fragment() {

    companion object {
        fun newInstance() = TransferenciasFragment()
    }

    private lateinit var viewModel: TransferenciasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transferencias, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TransferenciasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}