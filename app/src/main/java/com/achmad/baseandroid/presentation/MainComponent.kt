package com.achmad.baseandroid.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.achmad.feature.post.data.model.PostItem

@Composable
fun RowPost(
    model: PostItem,
    onItemClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onItemClick)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            text = model.title
        )
    }
}

@Composable
fun MessageLabel(message: String) {
    Text(
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.sp
        ),
        text = message
    )
}
