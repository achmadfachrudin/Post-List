package com.achmad.baseandroid.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import com.achmad.baseandroid.theme.BaseColor
import com.achmad.baseandroid.theme.BaseComposeTheme
import com.achmad.feature.post.data.model.PostItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchPostList()

        setContent {
            BaseComposeTheme {
                Surface(color = BaseColor.White) {
                    MainScreen(
                        viewModel = viewModel,
                        onSearchChanged = {
                            viewModel.fetchPostList(filter = it)
                        },
                        onItemClick = { goToUserDetail(it) }
                    )
                }
            }
        }
    }

    private fun goToUserDetail(postItem: PostItem) {
        startActivity(
            DetailActivity.createIntent(
                this,
                postItem
            )
        )
    }
}
