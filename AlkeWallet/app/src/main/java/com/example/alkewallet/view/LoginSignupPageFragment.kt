package com.example.alkewallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alkewallet.R
import com.example.alkewallet.databinding.FragmentLoginSignupPageBinding


class LoginSignupPageFragment : Fragment() {

    private lateinit var binding:FragmentLoginSignupPageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentLoginSignupPageBinding.inflate(inflater,container,false)
        binding.buttonCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_loginSignupPage_to_signupPage)
        }
        binding.textViewYaTieneCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_loginSignupPage_to_loginPage)
        }
        return binding.root
    }

}
