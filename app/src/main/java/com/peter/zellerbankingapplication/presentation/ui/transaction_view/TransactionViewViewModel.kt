package com.peter.zellerbankingapplication.presentation.ui.transaction_view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peter.zellerbankingapplication.domain.model.BankTransaction
import com.peter.zellerbankingapplication.repository.TransactionRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Named

@ExperimentalCoroutinesApi
class TransactionViewViewModel
@ViewModelInject
constructor(
    private val transactionRepository: TransactionRepository
): ViewModel(){


    val loading = mutableStateOf(false)
    var transactions: MutableState<List<BankTransaction>> = mutableStateOf(ArrayList())

    init {
        viewModelScope.launch {
            getTransactions()
        }
    }

    private suspend fun getTransactions() {
        loading.value = true

        delay(1000)

        val result = transactionRepository.getTransactions(
        )
        transactions.value = result

        loading.value = false
    }



}