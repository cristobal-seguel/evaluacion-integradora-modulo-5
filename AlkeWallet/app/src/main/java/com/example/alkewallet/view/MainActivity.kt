package com.example.alkewallet.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.alkewallet.R
import com.example.alkewallet.model.Transaction
import com.example.alkewallet.model.TransactionData
import com.example.alkewallet.model.Usuario
import com.example.alkewallet.model.UsuarioData
import com.example.alkewallet.viewModel.TransactionViewModel
import com.example.alkewallet.viewModel.UserViewModel
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainActivity : AppCompatActivity() {

    val formatter= DateTimeFormatter.ofPattern("MMM dd yy HH:mm:ss", Locale("ES") )
    val transactionViewModel=TransactionViewModel()
    val userViewModel=UserViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AlkeWallet)
        setContentView(R.layout.activity_main)
    }
}