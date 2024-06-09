package com.example.alkewallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.alkewallet.R
import com.example.alkewallet.databinding.FragmentSendMoneyBinding
import com.example.alkewallet.model.Transaction
import com.example.alkewallet.model.TransactionData
import com.example.alkewallet.model.Usuario
import com.example.alkewallet.model.UsuarioData
import java.time.LocalDateTime


class SendMoneyFragment : Fragment() {

    lateinit var _binding:FragmentSendMoneyBinding
    private val args:SendMoneyFragmentArgs by navArgs()
    private lateinit var userReceiver: Usuario

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSendMoneyBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        do {
            userReceiver= UsuarioData.getRandomUser()
        }while (userReceiver.id==args.userIdSender)
        _binding.imageViewProfile.setImageResource(requireContext().resources.getIdentifier(userReceiver.imagenPerfil,"drawable",requireContext().packageName))
        _binding.textViewCorreoProfile.text=userReceiver.email
        _binding.textViewProfile.text=userReceiver.nombres.plus(" ").plus(userReceiver.apellidos)
        _binding.imageViewAtras.setOnClickListener {
            findNavController().navigate(R.id.action_sendMoneyFragment_pop)
        }
        _binding.buttonEnviarDinero.setOnClickListener {
            if (_binding.editTextCantidad.text.toString()!="")

                if (UsuarioData.buscarUsuariPorId(args.userIdSender)!!.saldo>=_binding.editTextCantidad.text.toString().toInt())
                {
                    (activity as MainActivity).transactionViewModel.addTransaction(
                        Transaction(
                            TransactionData.generarIdTransaction(),args.userIdSender,userReceiver.id,_binding.editTextCantidad.text.toString().toInt(),
                            LocalDateTime.now())
                    )
                    (activity as MainActivity).userViewModel.updateSaldoUser(userReceiver.id,userReceiver.saldo+_binding.editTextCantidad.text.toString().toInt())
                    (activity as MainActivity).userViewModel.updateSaldoUser(args.userIdSender,UsuarioData.buscarUsuariPorId(args.userIdSender)!!.saldo -_binding.editTextCantidad.text.toString().toInt())
                    Toast.makeText(requireContext(),"Transaccion realizada exitosamente", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_sendMoneyFragment_pop)
                }
                else
                    Toast.makeText(requireContext(),"Saldo insuficiente", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(requireContext(),"Debe ingresar cantidad", Toast.LENGTH_SHORT).show()
        }
    }
}