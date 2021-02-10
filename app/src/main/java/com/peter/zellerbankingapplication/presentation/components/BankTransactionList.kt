package com.peter.zellerbankingapplication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.peter.zellerbankingapplication.domain.model.BankTransaction
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun BankTransactionList(
    loading: Boolean,
    transactions: List<BankTransaction>
) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.surface)
    ) {

        LazyColumn {
            itemsIndexed(
                items = transactions
            ) { index, tr ->

                BankTransactionCard(
                    transaction = tr,
                    onClick = {}
                )
            }
        }
    }
}