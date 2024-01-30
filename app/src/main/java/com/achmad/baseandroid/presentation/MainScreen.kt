package com.achmad.baseandroid.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.achmad.baseandroid.R
import com.achmad.baseandroid.core.network.ApiResult
import com.achmad.baseandroid.service.data.model.PostItem
import com.achmad.baseandroid.theme.BaseTextStyle
import com.achmad.baseandroid.theme.component.BaseDivider
import com.achmad.baseandroid.theme.component.BaseOutlinedTextField
import com.achmad.baseandroid.theme.component.BaseText
import com.achmad.baseandroid.theme.component.BaseToolbar
import com.achmad.baseandroid.theme.component.EmptyState
import com.achmad.baseandroid.theme.component.ErrorState
import com.achmad.baseandroid.theme.component.LoadingState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onSearchChanged: (filter: String) -> Unit = {},
    onItemClick: (model: PostItem) -> Unit
) {
    val uiState = viewModel.uiState.collectAsState().value
    var value by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            BaseToolbar(
                title = stringResource(id = R.string.app_name),
                showLeftButton = false,
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
            ) {
                BaseOutlinedTextField(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    value = value,
                    onValueChange = {
                        value = it
                        onSearchChanged(it)
                    },
                    label = { BaseText("Search title") },
                    maxLines = 1,
                    singleLine = true,
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    )
                )

                when (uiState) {
                    ApiResult.Loading -> {
                        LoadingState()
                    }

                    is ApiResult.Error -> {
                        ErrorState(message = uiState._error)
                    }

                    is ApiResult.Success -> {
                        if (uiState._data.isNotEmpty()) {
                            Card(modifier = Modifier.fillMaxWidth()) {
                                LazyColumn {
                                    items(uiState._data) { model ->
                                        PostCard(model) { onItemClick(model) }
                                        BaseDivider()
                                    }
                                }
                            }
                        } else {
                            EmptyState(message = "$value not found")
                        }
                    }
                }

            }
        }
    )
}

@Composable
fun PostCard(
    model: PostItem,
    onItemClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onItemClick)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        BaseText(
            style = BaseTextStyle.regular16,
            text = model.title
        )
    }
}
