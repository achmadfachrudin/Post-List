package com.achmad.baseandroid.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun BaseComposeTheme(
    content:
        @Composable()
        () -> Unit,
) {
    MaterialTheme(
        shapes = BaseShapes.Shapes,
        content = content,
    )
}
