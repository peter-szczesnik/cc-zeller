package com.peter.zellerbankingapplication.presentation.ui.manual_entry

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peter.zellerbankingapplication.domain.util.getAmount
import com.peter.zellerbankingapplication.domain.util.isAmountValid
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

    fun onAmountChanged(amount: String) {
        setAmount(amount)
    }

    private fun setAmount(amount: String) {
        isInsufficientFunds.value = false
        if (isAmountValid(amount)) {
            isError.value = false
            this.amount.value = amount
        } else {
            isError.value = true
            this.amount.value = ""
        }
    }

    fun processDeposit() {
        if(amount.value == "") return
        viewModelScope.launch {
            loading.value = true
            transactionRepository.processDeposit(getAmount(amount.value))
            delay(1000)
            loading.value = false
            setAmount("")
        }
    }

    fun processWithdrawal() {
        if(amount.value == "") return
        viewModelScope.launch {
            if (transactionRepository.getBalance() > getAmount(amount.value)) {
                loading.value = true
                transactionRepository.processWithdrawal(getAmount(amount.value))
                delay(1000)
                loading.value = false
                setAmount("")
            } else {
                isInsufficientFunds.value = true
            }
        }
    }

}
















