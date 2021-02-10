package com.peter.zellerbankingapplication.domain.model


data class BankTransaction (
    val id: Long? = null,
    val amount: Double? = null,
    val transactionType: String? = null,
)