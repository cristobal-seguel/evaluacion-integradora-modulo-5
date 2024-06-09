package com.example.alkewallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.alkewallet.R
import com.example.alkewallet.databinding.FragmentSignupPageBinding
import com.example.alkewallet.model.Usuario
import com.example.alkewallet.model.UsuarioData

class SignupPageFragment : Fragment() {

    private lateinit var _binding:FragmentSignupPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentSignupPageBinding.inflate(inflater,container,false)
        _binding.textViewYaTienesCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_signupPage_to_loginPage)
        }
        _binding.buttonCrearCuenta.setOnClickListener {
            if (_binding.editTextTextNombre.text.toString()!="" && _binding.editTextApellido.text.toString()!=""&&_binding.editTextEmail.text.toString()!=""&&_binding.textInputEditTextContrasena.text.toString()!=""&&_binding.textInputEditTextReingresarContrasena.text.toString()!="")
            {
                if (_binding.textInputEditTextContrasena.text.toString()==_binding.textInputEditTextReingresarContrasena.text.toString())
                {
                    val idUsuario=UsuarioData.generarIdUsuario()
                    UsuarioData.addUsuario(Usuario(idUsuario,_binding.editTextTextNombre.text.toString(),_binding.editTextApellido.text.toString(),_binding.editTextEmail.text.toString(),_binding.textInputEditTextContrasena.text.toString(),0,"general_picture_profile"))
                    findNavController().navigate(SignupPageFragmentDirections.actionSignupPageToHomePage(idUsuario))
                }
                else
                    Toast.makeText(requireContext(),"Contraseñas no coinciden, vuelva a intentarlo",Toast.LENGTH_SHORT).show()

            }
            else
                Toast.makeText(requireContext(),"Debe ingresar todos los campos",Toast.LENGTH_SHORT).show()

        }
        return _binding.root
    }


}