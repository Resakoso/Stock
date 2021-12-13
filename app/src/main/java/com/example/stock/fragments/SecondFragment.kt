package com.example.stock.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.stock.ArticulosViewModel
import com.example.stock.R
import com.example.stock.databinding.FragmentSecondBinding
import com.example.stock.model.Articulos

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    val articulosViewModel: ArticulosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.aniadir.setOnClickListener {
            if(TextUtils.isEmpty(binding.identificador.text.toString()) || TextUtils.isEmpty(binding.descripcion.text.toString()) || TextUtils.isEmpty(binding.cantidad.text.toString())){
                Toast.makeText(requireContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                articulosViewModel.insertArticulo(Articulos(binding.identificador.text.toString(),binding.descripcion.text.toString(), binding.cantidad.text.toString()))
                Toast.makeText(requireContext(), "Artículo añadida con exito", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}