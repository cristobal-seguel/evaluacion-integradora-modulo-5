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
import com.example.alkewallet.databinding.FragmentRequestMoneyBinding
import com.example.alkewallet.model.Transaction
import com.example.alkewallet.model.TransactionData
import com.example.alkewallet.model.Usuario
import com.example.alkewallet.model.UsuarioData
import com.example.alkewallet.viewModel.TransactionViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.random.Random


class RequestMoneyFragment : Fragment() {

    private lateinit var _binding:FragmentRequestMoneyBinding
    private val args:RequestMoneyFragmentArgs by navArgs()
    private lateinit var userSender:Usuario


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentRequestMoneyBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        do {
            userSender=UsuarioData.getRandomUser()
        }while (userSender.id==args.idUserReceiver)
        _binding.imageViewProfile.setImageResource(requireContext().resources.getIdentifier(userSender.imagenPerfil,"drawable",requireContext().packageName))
        _binding.textViewCorreoProfile.text=userSender.email
        _binding.textViewProfile.text=userSender.nombres.plus(" ").plus(userSender.apellidos)
        _binding.imageViewAtras.setOnClickListener {
            findNavController().navigate(R.id.action_requestMoneyFragment_pop)
        }
        _binding.buttonIngresarDinero.setOnClickListener {
            if (_binding.editTextTextCantidad.text.toString()!="")

                if (userSender.saldo>=_binding.editTextTextCantidad.text.toString().toInt())
                {
                    (activity as MainActivity).transactionViewModel.addTransaction(Transaction(TransactionData.generarIdTransaction(),userSender.id,args.idUserReceiver,_binding.editTextTextCantidad.text.toString().toInt(),LocalDateTime.now()))
                    (activity as MainActivity).userViewModel.updateSaldoUser(userSender.id,userSender.saldo-_binding.editTextTextCantidad.text.toString().toInt())
                    (activity as MainActivity).userViewModel.updateSaldoUser(args.idUserReceiver,UsuarioData.buscarUsuariPorId(args.idUserReceiver)!!.saldo +_binding.editTextTextCantidad.text.toString().toInt())
                    Toast.makeText(requireContext(),"Transaccion realizada exitosamente",Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_requestMoneyFragment_pop)
                }
                else
                    Toast.makeText(requireContext(),"Saldo insuficiente",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(requireContext(),"Debe ingresar cantidad",Toast.LENGTH_SHORT).show()
        }
    }


}