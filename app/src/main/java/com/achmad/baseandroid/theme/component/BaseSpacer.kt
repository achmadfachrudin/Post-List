package com.achmad.baseandroid.theme.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.achmad.baseandroid.theme.BaseColor

@Composable
fun BaseSpacerVertical(height: Int = 16) {
    Spacer(modifier = Modifier.fillMaxWidth().height(height.dp))
}

@Composable
fun BaseSpacerHorizontal(width: Int = 16) {
    Spacer(modifier = Modifier.height(2.dp).width(width.dp))
}

@Composable
fun BaseDivider(modifier: Modifier = Modifier) {
    Spacer(
        modifier =
            modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(BaseColor.GreyLight),
    )
}
