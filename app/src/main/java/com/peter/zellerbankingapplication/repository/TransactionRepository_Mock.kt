package com.peter.zellerbankingapplication.repository

import com.peter.zellerbankingapplication.domain.model.BankTransaction

class TransactionRepository_Mock : TransactionRepository {

    private var transactions = ArrayList<BankTransaction>()

    init {
        (1..10).forEach {
            transactions.add(
                BankTransaction(it.toLong(), it.toDouble()*2, "Deposit" )
            )
        }
        (1..10).forEach {
            transactions.add(
                BankTransaction((it + 100).toLong(), it.toDouble(), "Withdrawal" )
            )
        }
    }

    override suspend fun getTransactions(): List<BankTransaction> {
        return transactions.reversed()
    }

    override suspend fun processDeposit(amount: Double) {
        transactions.add(
            BankTransaction(
                id = transactions.maxOf { it.id!! } + 1,
                amount = amount,
                transactionType = "Deposit"
            )
        )
    }

    override suspend fun processWithdrawal(amount: Double) {
        transactions.add(
            BankTransaction(
                id = transactions.maxOf { it.id!! } + 1,
                amount = amount,
                transactionType = "Withdrawal"
            )
        )
    }

    override suspend fun getBalance(): Double {
        var balance = 0.0
        transactions.forEach {
            if(it.transactionType == "Deposit") balance += it.amount!!
            else balance -= it.amount!!
        }
        return balance
    }
}