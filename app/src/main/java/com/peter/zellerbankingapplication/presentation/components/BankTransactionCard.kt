package com.peter.zellerbankingapplication.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.peter.zellerbankingapplication.domain.model.BankTransaction
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@Composable
fun BankTransactionCard(
    transaction: BankTransaction,
    onClick: () -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = transaction.id.toString(),
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentWidth(Alignment.Start),
                style = MaterialTheme.typography.h3
            )
            Text(
                text = transaction.transactionType!!,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentWidth(Alignment.Start)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h5
            )
            Text(
                text = transaction.amount.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h5
            )
        }
    }
}