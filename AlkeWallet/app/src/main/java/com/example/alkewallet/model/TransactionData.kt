package com.example.alkewallet.model

import com.example.alkewallet.view.MainActivity
import java.time.LocalDateTime
import kotlin.random.Random

class TransactionData {

    companion object {

        private var transactionList= mutableListOf<Transaction>(
            Transaction(10, 6, 1, 15000, generarFechaAleatoriaTransaccion()),
            Transaction(9, 2, 6, 20500, generarFechaAleatoriaTransaccion()),
            Transaction(8, 3, 6, 12400, generarFechaAleatoriaTransaccion()),
            Transaction(7, 6, 4, 21300, generarFechaAleatoriaTransaccion()),
            Transaction(6, 5, 6, 9000, generarFechaAleatoriaTransaccion()))

        fun getTrasactions():MutableList<Transaction> {
            transactionList.sortByDescending { it.dateTime}
            return transactionList
        }

        fun getTrasactionsByUserId(userId:Int): MutableList<Transaction> {

                var listadoTransaccionesPorUsuario= mutableListOf<Transaction>()
                for (transaction in transactionList)
                {
                    if (transaction.senderUserId==userId || transaction.receiverUserId==userId)
                        listadoTransaccionesPorUsuario.add(transaction)
                }

            return listadoTransaccionesPorUsuario
        }

        fun addTransaction(transaction:Transaction)
        {
            transactionList.add(transaction)
        }

        fun generarIdTransaction():Int{
            val idMaximo= transactionList.maxOfOrNull { it.transactionId }
            return idMaximo!!+1
        }

        fun generarFechaAleatoriaTransaccion():LocalDateTime
        {
            val dateTime=LocalDateTime.now()
            return dateTime.minusSeconds(Random.nextInt(86400,155520000).toLong())

        }
    }
}