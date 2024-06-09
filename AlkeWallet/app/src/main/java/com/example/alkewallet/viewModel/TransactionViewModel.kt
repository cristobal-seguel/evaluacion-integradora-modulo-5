package com.example.alkewallet.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewallet.model.Transaction
import com.example.alkewallet.model.TransactionData

class TransactionViewModel:ViewModel() {

    private val transactionList= MutableLiveData<MutableList<Transaction>>()
    val transactionListLv:LiveData<MutableList<Transaction>>
        get() = transactionList

    init {
        transactionList.value=TransactionData.getTrasactions()

    }
    fun addTransaction(transaction: Transaction)
    {
        TransactionData.addTransaction(transaction)
        transactionList.value=TransactionData.getTrasactions()
    }


}