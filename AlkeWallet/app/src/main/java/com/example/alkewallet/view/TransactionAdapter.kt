package com.example.alkewallet.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewallet.R
import com.example.alkewallet.databinding.TransactionItemBinding
import com.example.alkewallet.model.Transaction
import com.example.alkewallet.model.TransactionData
import com.example.alkewallet.model.UsuarioData
import java.text.NumberFormat
import java.util.Locale

class TransactionAdapter( private val transactionList:MutableList<Transaction>, private val context :Context,private val idUser: Int):RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {


    override fun onBindViewHolder(holder: TransactionAdapter.TransactionViewHolder, position: Int) {

        val transaction: Transaction = transactionList[position]
        holder.bind(transaction)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {

        return TransactionViewHolder(TransactionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),context,idUser)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    inner class TransactionViewHolder(private var bindingItem: TransactionItemBinding,private val context : Context,private val idUsuario :Int):RecyclerView.ViewHolder(bindingItem.root){

        fun bind(transaction:Transaction)
        {
            val nombreUsuario:String
            val srcImageUser:String
            var srcImageTipoTransaction="send_icon_profile_svg"
            var signoTransaction="-$"
            if (transaction.senderUserId==idUsuario) {
                srcImageUser =UsuarioData.buscarUsuariPorId(transaction.receiverUserId)!!.imagenPerfil.toString()
                nombreUsuario=UsuarioData.buscarUsuariPorId(transaction.receiverUserId)!!.nombres
            }
            else
            {
                nombreUsuario=UsuarioData.buscarUsuariPorId(transaction.senderUserId)!!.nombres
                srcImageUser =UsuarioData.buscarUsuariPorId(transaction.senderUserId)!!.imagenPerfil.toString()
                srcImageTipoTransaction="request_icon_profile_svg"
                signoTransaction="+$"

            }
            bindingItem.imageViewProfileTransaccion.setImageResource(context.resources.getIdentifier(srcImageUser,"drawable",context.packageName))
            bindingItem.imageViewtipoTransaccion.setImageResource(context.resources.getIdentifier(srcImageTipoTransaction,"drawable",context.packageName))
            bindingItem.textViewAmount.text=signoTransaction.plus(NumberFormat.getInstance(Locale.getDefault()).format(transaction.amount))
            bindingItem.textViewNombre.text=nombreUsuario
            bindingItem.textViewFecha.text=transaction.dateTime.format(MainActivity().formatter)

        }
    }
}