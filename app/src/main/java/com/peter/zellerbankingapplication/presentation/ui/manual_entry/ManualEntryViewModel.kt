package com.peter.zellerbankingapplication.presentation.ui.manual_entry

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peter.zellerbankingapplication.repository.TransactionRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Named


class ManualEntryViewModel
@ViewModelInject
constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {


    val isError = mutableStateOf(false)
    val isInsufficientFunds = mutableStateOf(false)
    val loading = mutableStateOf(false)
    val amount = mutableStateOf("")

    var amountDouble = 0.0

    init {
    }


    fun onAmountChanged(query: String) {
        setAmount(query)
    }

    private fun setAmount(amount: String) {
        isInsufficientFunds.value = false
        if (validateAmount(amount)) {
            isError.value = false
            this.amount.value = amount
        } else {
            isError.value = true
            this.amount.value = ""
        }
    }

    private fun validateAmount(amount: String): Boolean {
        if (amount == "") return true
        try {
            val amt = amount.toDouble()
            amountDouble = amt
            return amt != 0.0
        } catch (ex: Exception) {
            amountDouble = 0.0
            return false
        }
    }

    fun processDeposit() {
        viewModelScope.launch {
            loading.value = true
            transactionRepository.processDeposit(amountDouble)
            delay(1000)
            loading.value = false
            setAmount("")
        }
    }

    fun processWithdrawal() {
        viewModelScope.launch {
            if (transactionRepository.getBalance() > amountDouble) {
                loading.value = true
                transactionRepository.processWithdrawal(amountDouble)
                delay(1000)
                loading.value = false
                setAmount("")
            } else {
                isInsufficientFunds.value = true
            }
        }
    }

}
















