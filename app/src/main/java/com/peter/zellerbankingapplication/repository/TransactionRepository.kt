package com.peter.zellerbankingapplication.repository

import com.peter.zellerbankingapplication.domain.model.BankTransaction

interface TransactionRepository {

    suspend fun getTransactions() : List<BankTransaction>
    suspend fun processDeposit(amount: Double)
    suspend fun processWithdrawal(amount: Double)
    suspend fun getBalance() : Double

}
