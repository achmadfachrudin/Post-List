package com.achmad.baseandroid.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.achmad.baseandroid.R
import com.achmad.baseandroid.service.data.model.PostItem
import com.achmad.baseandroid.theme.BaseTextStyle
import com.achmad.baseandroid.theme.component.BaseButton
import com.achmad.baseandroid.theme.component.BaseOutlinedButton
import com.achmad.baseandroid.theme.component.BaseOutlinedTextField
import com.achmad.baseandroid.theme.component.BaseSpacerVertical
import com.achmad.baseandroid.theme.component.BaseText
import com.achmad.baseandroid.theme.component.BaseTextButton
import com.achmad.baseandroid.theme.component.BaseTextField
import com.achmad.baseandroid.theme.component.BaseToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    model: PostItem,
    onLeftButtonClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                title = stringResource(id = R.string.title_feature_detail),
                showLeftButton = true,
                onLeftButtonClick = onLeftButtonClick
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(16.dp),
            ) {

                var value by remember { mutableStateOf("") }

                BaseText(
                    style = BaseTextStyle.bold24,
                    text = model.title
                )
                BaseText(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    text = model.body
                )
            }
        }
    )
}
