package com.peter.zellerbankingapplication.presentation.ui.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Named

const val PAGE_SIZE = 30

const val STATE_KEY_PAGE = "recipe.state.page.key"
const val STATE_KEY_QUERY = "recipe.state.query.key"
const val STATE_KEY_LIST_POSITION = "recipe.state.query.list_position"
const val STATE_KEY_SELECTED_CATEGORY = "recipe.state.query.selected_category"

class ManualEntryViewModel
@ViewModelInject
constructor(
    //private val repository: TransactionRepository,
) : ViewModel() {



    val loading = mutableStateOf(false)
    val amount = mutableStateOf("")

    init {
    }


    fun onAmountChanged(query: String) {
        setAmount(query)
    }

    private fun setAmount(amount: String){
        this.amount.value = amount
    }
}
















