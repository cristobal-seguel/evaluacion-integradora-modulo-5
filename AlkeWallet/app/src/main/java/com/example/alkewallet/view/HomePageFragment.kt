package com.example.alkewallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alkewallet.databinding.FragmentHomePageBinding
import com.example.alkewallet.model.TransactionData
import com.example.alkewallet.model.UsuarioData
import java.text.NumberFormat
import java.util.Locale


class HomePageFragment : Fragment() {

    private lateinit var _binding:FragmentHomePageBinding
    private val args:HomePageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentHomePageBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val usuario=UsuarioData.buscarUsuariPorId(args.idUser)
        (activity as MainActivity).userViewModel.userListLv.observe(viewLifecycleOwner, Observer {
            _binding.textViewSaldo.text="$".plus(NumberFormat.getInstance(Locale.getDefault()).format(usuario!!.saldo))
            _binding.textViewHola.text="Hola ".plus( usuario.nombres)
            _binding.imageViewProfile.setImageResource(requireContext().resources.getIdentifier(usuario.imagenPerfil,"drawable",requireContext().packageName))
            _binding.imageNotificaciones.visibility=View.GONE })
        (activity as MainActivity).transactionViewModel.transactionListLv.observe(viewLifecycleOwner, Observer {
            val transactionAdaptador = TransactionAdapter(TransactionData.getTrasactionsByUserId(args.idUser),requireContext(),args.idUser)
            if (transactionAdaptador.itemCount>0)
            {
                _binding.recyclerViewTransactions.layoutManager= LinearLayoutManager(requireContext())
                _binding.recyclerViewTransactions.adapter = transactionAdaptador
                _binding.imageViewNoHayTransacciones.visibility = View.GONE
                _binding.textViewNoHayTransacciones.visibility=View.GONE
            }
            else
            {
                _binding.imageViewNoHayTransacciones.visibility = View.VISIBLE
                _binding.textViewNoHayTransacciones.visibility=View.VISIBLE
            }
        })

        _binding.buttonEnviarDinero.setOnClickListener {
            val caracteresAEliminar=setOf('.',',','$')
            if (_binding.textViewSaldo.text.toString().filter { it !in caracteresAEliminar }.toInt()!=0)
                findNavController().navigate(HomePageFragmentDirections.actionHomePageToSendMoneyFragment(args.idUser))
            else
                Toast.makeText(requireContext(),"No tiene saldo para enviar dinero",Toast.LENGTH_SHORT).show()
        }
        _binding.buttonIngresarDinero.setOnClickListener {
            findNavController().navigate(HomePageFragmentDirections.actionHomePageToRequestMoneyFragment(args.idUser))
        }

        _binding.imageViewProfile.setOnClickListener {
            findNavController().navigate(HomePageFragmentDirections.actionHomePageToProfilePageFragment(args.idUser))
        }
    }
}