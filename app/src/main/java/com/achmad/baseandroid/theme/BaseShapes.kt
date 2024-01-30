package com.achmad.baseandroid.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

object BaseShapes {
    val small = RoundedCornerShape(4.dp)
    val medium = RoundedCornerShape(4.dp)
    val large = RoundedCornerShape(4.dp)

    val Shapes =
        Shapes(
            small = small,
            medium = medium,
            large = large,
        )
}
