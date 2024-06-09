package com.example.alkewallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.alkewallet.R
import com.example.alkewallet.databinding.FragmentProfilePageBinding
import com.example.alkewallet.model.UsuarioData


class ProfilePageFragment : Fragment() {

    lateinit var _binding:FragmentProfilePageBinding
    private val args:ProfilePageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentProfilePageBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val usuario=UsuarioData.buscarUsuariPorId(args.idUser)
        _binding.imageViewProfile.setImageResource(requireContext().resources.getIdentifier(usuario!!.imagenPerfil,"drawable",requireContext().packageName))
        _binding.textViewProfile.text=usuario.nombres.plus(" ").plus(usuario.apellidos)

    }





}