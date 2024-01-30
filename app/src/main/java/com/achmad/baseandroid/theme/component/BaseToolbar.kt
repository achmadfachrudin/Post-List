package com.achmad.baseandroid.theme.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.achmad.baseandroid.R
import com.achmad.baseandroid.theme.BaseTextStyle

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseToolbar(
    title: String = "",
    showLeftButton: Boolean = true,
    showOptionalButton: Boolean = false,
    showRightButton: Boolean = false,
    leftButtonImage: Painter = painterResource(R.drawable.ic_arrow_left),
    optionalButtonImage: Painter = painterResource(R.drawable.ic_arrow_left),
    rightButtonImage: Painter = painterResource(R.drawable.ic_arrow_left),
    onLeftButtonClick: () -> Unit = {},
    onOptionalButtonClick: () -> Unit = {},
    onRightButtonClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.shadow(6.dp),
        title = {
            BaseText(
                text = title,
                style = BaseTextStyle.bold24,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            if (showLeftButton) {
                IconButton(onClick = onLeftButtonClick) {
                    Icon(
                        painter = leftButtonImage,
                        contentDescription = "",
                    )
                }
            }
        },
        actions = {
            Row {
                if (showOptionalButton) {
                    IconButton(onClick = onOptionalButtonClick) {
                        Icon(
                            painter = optionalButtonImage,
                            contentDescription = "",
                        )
                    }
                }
                if (showRightButton) {
                    IconButton(onClick = onRightButtonClick) {
                        Icon(
                            painter = rightButtonImage,
                            contentDescription = "",
                        )
                    }
                }
            }
        },
    )
}
