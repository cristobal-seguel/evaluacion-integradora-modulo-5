package com.example.alkewallet.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewallet.model.Usuario
import com.example.alkewallet.model.UsuarioData

class UserViewModel:ViewModel() {

    private val userList= MutableLiveData<MutableList<Usuario>>()
    val userListLv: LiveData<MutableList<Usuario>>
        get() = userList

    init {
        userList.value= UsuarioData.getUsuarios()
    }

    fun updateSaldoUser(idUser:Int,saldo:Int)
    {
        UsuarioData.updateSaldoUser(idUser,saldo)
        userList.value=UsuarioData.getUsuarios()
    }
}