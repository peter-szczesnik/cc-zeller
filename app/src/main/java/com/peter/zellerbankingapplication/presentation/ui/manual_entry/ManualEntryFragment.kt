package com.peter.zellerbankingapplication.presentation.ui.manual_entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Money
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.peter.zellerbankingapplication.presentation.BaseApplication
import com.peter.zellerbankingapplication.presentation.ui.recipe_list.ManualEntryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ManualEntryFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewModel: ManualEntryViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {


                val amount = viewModel.amount.value

                val loading = viewModel.loading.value

                val scaffoldState = rememberScaffoldState()

                    Scaffold(
                        topBar = {
                            Text(
                                text = "Manual Input of Transactions",
                                style = MaterialTheme.typography.h3,
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
                            )

                        },
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        },

                        ) {
                        Column(
                            modifier = Modifier.padding(
                                horizontal = 24.dp,
                            )
                        ){
                            Spacer(modifier = Modifier.height(40.dp))
                            Row(modifier = Modifier.fillMaxWidth()){
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                    ,
                                    value = amount,
                                    onValueChange =
                                    viewModel::onAmountChanged
                                    //onQueryChanged(it)
                                    ,
                                    label = {
                                        Text(text = "Enter Amount")
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Done,
                                    ),
                                    leadingIcon = {
                                        Icon(Icons.Filled.Money)
                                    },
                                    onImeActionPerformed = { action, softKeyboardController ->
                                        if (action == ImeAction.Done) {
                                            softKeyboardController?.hideSoftwareKeyboard()
                                        }
                                    },
                                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                    backgroundColor = MaterialTheme.colors.surface
                                )
                            }
                            Spacer(modifier = Modifier.height(40.dp))
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = { /*TODO*/ }) {
                                Text(text = "Process Deposit")
                            }
                            Spacer(modifier = Modifier.height(40.dp))
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = { /*TODO*/ }) {
                                Text(text = "Process Withdrawal")
                            }
                            Spacer(modifier = Modifier.height(40.dp))
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {}// {findNavController().navigate(R.id.viewRecipe)}
                            ) {
                                Text(text = "View Transactions")
                            }
                        }
                    }
            }
        }
    }
}


