package com.peter.zellerbankingapplication.presentation.ui.transaction_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.peter.zellerbankingapplication.presentation.BaseApplication
import com.peter.zellerbankingapplication.presentation.components.BankTransactionList
import com.peter.zellerbankingapplication.presentation.components.MyProgressBar

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class TransactionViewFragment: Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewModel: TransactionViewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val loading = viewModel.loading.value
                val transactions = viewModel.transactions.value

                    Scaffold(
                        topBar = {
                            Text(
                                text = "View Transactions",
                                style = MaterialTheme.typography.h4,
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier.fillMaxWidth()
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )

                        }
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            BankTransactionList(
                                loading = loading,
                                transactions = transactions,
                            )
                            MyProgressBar(
                                isDisplayed = loading,
                                verticalBias = 0.3f
                            )

                        }
                    }
            }
        }
    }
}


