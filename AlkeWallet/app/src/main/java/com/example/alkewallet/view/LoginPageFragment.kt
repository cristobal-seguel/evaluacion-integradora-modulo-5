package com.example.alkewallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.alkewallet.R
import com.example.alkewallet.databinding.FragmentLoginPageBinding
import com.example.alkewallet.model.UsuarioData

class LoginPageFragment : Fragment() {

    private lateinit var _binding:FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
            _binding=FragmentLoginPageBinding.inflate(inflater,container,false)
            _binding.textViewCrearCuenta.setOnClickListener {
                findNavController().navigate(R.id.action_loginPage_to_signupPage)
                }
            _binding.buttonLogin.setOnClickListener {
                if (_binding.editTextTextEmailAddress.text.toString()!="" && _binding.textInputEditTextContrasena.text.toString()!="")
                {
                    val usuario=UsuarioData.buscarUsuarioPorEmailYPassword(_binding.editTextTextEmailAddress.text.toString(),_binding.textInputEditTextContrasena.text.toString())
                    if (usuario!=null)
                        findNavController().navigate(LoginPageFragmentDirections.actionLoginPageToHomePage(usuario.id))
                    else
                        Toast.makeText(this.activity, "Login incorrecto", Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(this.activity,"Debe ingresar Email y contraseña",Toast.LENGTH_SHORT).show()
            }
            return _binding.root
        }
}