package com.achmad.baseandroid.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.achmad.baseandroid.service.data.model.PostItem
import com.achmad.baseandroid.theme.BaseComposeTheme

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val BUNDLE_KEY_POST = "BUNDLE_KEY_POST"

        fun createIntent(
            context: Context,
            post: PostItem
        ): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(BUNDLE_KEY_POST, post)
            }
        }
    }

    private val post by lazy {
        intent.getParcelableExtra<PostItem>(BUNDLE_KEY_POST)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BaseComposeTheme {
                post?.let {
                    DetailScreen(
                        model = it,
                        onLeftButtonClick = { onBackPressed() }
                    )
                }
            }
        }
    }
}
