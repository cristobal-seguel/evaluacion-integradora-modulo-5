package com.example.alkewallet.model

import java.time.LocalDateTime

data class Transaction (
    val transactionId:Int,
    val senderUserId:Int,
    val receiverUserId:Int,
    val amount:Int,
    val dateTime: LocalDateTime,
    val note:String="")