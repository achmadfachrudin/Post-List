package com.achmad.baseandroid.theme.component

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.achmad.baseandroid.theme.BaseComposeTheme

class ThemePreviewActivity : AppCompatActivity() {

    companion object {
        fun createIntent(
            context: Context,
        ): Intent {
            return Intent(context, ThemePreviewActivity::class.java).apply {
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BaseComposeTheme {
                ThemePreviewScreen(
                    onLeftButtonClick = { onBackPressed() }
                )
            }
        }
    }
}
