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


    val loading = mutableStateOf(false)
    val amount = mutableStateOf("")

    init {
    }


    fun onAmountChanged(query: String) {
        setAmount(query)
    }

    private fun setAmount(amount: String) {
        this.amount.value = amount
    }

    fun processDeposit() {
        viewModelScope.launch {
            try {
                loading.value = true
                transactionRepository.processDeposit(amount.value.toDouble())
                delay(1000)
            } catch (ex: Exception) {
            } finally {
                loading.value = false
                setAmount("")
            }
        }
    }

    fun processWithdrawal() {
        viewModelScope.launch {
            try {
                loading.value = true
                transactionRepository.processDeposit(amount.value.toDouble())
                delay(1000)
            } catch (ex: Exception) {
            }finally {
                loading.value = false
                setAmount("")
            }
        }
    }
}
















