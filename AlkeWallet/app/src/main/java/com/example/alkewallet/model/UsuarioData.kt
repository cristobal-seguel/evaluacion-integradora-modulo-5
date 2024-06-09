package com.example.alkewallet.model

import kotlin.random.Random

class UsuarioData {

    companion object {

        private var listadoUsuarios= mutableListOf<Usuario>(
        Usuario(1, "Yara", "Khalil", "yara_khalil@gmail.com", "yk123", 105000,"yara_khalil_picture"),
        Usuario(2, "Sara", "Ibrahim", "sara_ibrahim@outlook.com", "si123", 1500000,"sara_ibrahim_picture"),
        Usuario(3, "Amad", "Ibrahim", "amad_ibrahim@gmail.com", "ai123", 543000,"amad_ibrahim_picture"),
        Usuario(4, "Reem", "Khaled", "reem_khaled@outlook.com", "rk123", 250000,"reem_khaled_picture"),
        Usuario(5, "Hiba", "Saleh", "hiba_saleh@gmail.com", "is123", 867000,"hiba_saleh_picture"),
        Usuario(6, "Amanda", "Fuentes", "amanda_fuentes@gmail.com", "af123", 7000,"amanda_fuentes_picture"))

        fun getUsuarios(): MutableList<Usuario> {
            return listadoUsuarios
        }

        fun addUsuario(usuario:Usuario)
        {
            listadoUsuarios.add(usuario)
        }

        fun buscarUsuarioPorEmailYPassword(email:String,password:String):Usuario? {
            var usuario:Usuario?=null
            for (us in UsuarioData.getUsuarios()) {
                if (us.email == email && us.contrasena == password) {
                    usuario = us
                    break
                }
            }
            return usuario
        }

        fun buscarUsuariPorId(id:Int):Usuario? {
            var usuario:Usuario?=null
            for (u in UsuarioData.getUsuarios()) {
                if (u.id == id) {
                    usuario=u
                    break
                }
            }
            return usuario
        }

        fun generarIdUsuario():Int{
            val idMaximo=listadoUsuarios.maxOfOrNull { it.id }
            return idMaximo!!+1
        }

        fun getRandomUser ():Usuario
        {
            return listadoUsuarios[Random.nextInt(0, listadoUsuarios.size)]
        }

        fun updateSaldoUser (idUser:Int,saldo:Int)
        {
            buscarUsuariPorId(idUser)!!.saldo=saldo
        }
    }
}