package com.achmad.baseandroid.theme.component

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
internal fun ThemePreviewScreen(
    onLeftButtonClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            BaseToolbar(
                title = stringResource(id = R.string.app_name),
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
                    text = "Bold 24"
                )

                BaseSpacerVertical()

                BaseText(
                    style = BaseTextStyle.bold16,
                    text = "Bold 16"
                )

                BaseSpacerVertical()

                BaseText(
                    style = BaseTextStyle.semiBold20,
                    text = "Semibold 20"
                )

                BaseSpacerVertical()

                BaseText(
                    style = BaseTextStyle.semiBold16,
                    text = "Semibold 16"
                )

                BaseSpacerVertical()

                BaseText(
                    style = BaseTextStyle.semiBold14,
                    text = "Semibold 14"
                )

                BaseSpacerVertical()

                BaseText(
                    style = BaseTextStyle.medium16,
                    text = "Medium 16"
                )

                BaseSpacerVertical()

                BaseText(
                    style = BaseTextStyle.medium12,
                    text = "Medium 12"
                )

                BaseSpacerVertical()

                BaseText(
                    style = BaseTextStyle.regular16,
                    text = "Regular 16"
                )

                BaseSpacerVertical()

                BaseText(
                    style = BaseTextStyle.regular14,
                    text = "Regular 14"
                )

                BaseSpacerVertical()

                BaseButton("Common button", {})

                BaseSpacerVertical()

                BaseOutlinedButton("Outline button", {})

                BaseSpacerVertical()

                BaseTextButton("Text button", {})

                BaseSpacerVertical()

                BaseTextField(value = value, onValueChange = { value = it })

                BaseSpacerVertical()

                BaseOutlinedTextField(value = value, onValueChange = { value = it })

                BaseSpacerVertical()
            }
        }
    )
}
