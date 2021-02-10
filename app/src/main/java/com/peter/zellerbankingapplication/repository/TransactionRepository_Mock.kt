package com.peter.zellerbankingapplication.repository

import com.peter.zellerbankingapplication.domain.model.BankTransaction

class TransactionRepository_Mock : TransactionRepository {

    private var transactions: List<BankTransaction> = listOf(
        BankTransaction(1,10.0, "Deposit"),
        BankTransaction(2,10.0, "Deposit"),
        BankTransaction(3,10.0, "Deposit"),
        BankTransaction(4,10.0, "Deposit"),
        BankTransaction(5,10.0, "Deposit"),
        BankTransaction(11,10.0, "Withdrawal"),
        BankTransaction(12,10.0, "Withdrawal"),
        BankTransaction(13,10.0, "Withdrawal"),
        BankTransaction(14,10.0, "Withdrawal"),
        BankTransaction(15,10.0, "Withdrawal"),
    )


    override suspend fun getTransactions(): List<BankTransaction> {
        return transactions
    }
}