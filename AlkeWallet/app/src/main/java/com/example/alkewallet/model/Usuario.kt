package com.example.alkewallet.model

data class Usuario (
    val id:Int,
    var nombres:String,
    var apellidos:String,
    var email:String,
    var contrasena:String,
    var saldo:Int,
    var imagenPerfil:String)
