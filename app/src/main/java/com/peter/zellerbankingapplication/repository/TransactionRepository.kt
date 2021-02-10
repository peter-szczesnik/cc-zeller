package com.peter.zellerbankingapplication.repository

import com.peter.zellerbankingapplication.domain.model.BankTransaction

interface TransactionRepository {


    suspend fun getTransactions() : List<BankTransaction>

}
