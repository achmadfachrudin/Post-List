package com.achmad.baseandroid.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.achmad.common.ApiResult
import com.achmad.feature.post.data.model.PostItem

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onSearchChanged: (filter: String) -> Unit = {},
    onItemClick: (model: PostItem) -> Unit
) {
    val state = viewModel.uiState.collectAsState().value
    var value by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            )
    ) {
        OutlinedTextField(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            value = value,
            onValueChange = {
                value = it
                onSearchChanged(it)
            },
            label = { Text("Search title") },
            maxLines = 1,
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )

        when (state) {
            ApiResult.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    )
                )
            }
            is ApiResult.Error -> {
                MessageLabel(message = "Oops, something wrong")
            }
            is ApiResult.Success -> {
                if (state._data.isNotEmpty()) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        LazyColumn {
                            items(state._data) { model ->
                                RowPost(model) { onItemClick(model) }
                                Divider()
                            }
                        }
                    }
                } else {
                    MessageLabel(message = "$value not found")
                }
            }
        }
    }
}
