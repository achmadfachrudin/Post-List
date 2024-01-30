package com.achmad.baseandroid.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.achmad.baseandroid.service.data.model.PostItem
import com.achmad.baseandroid.theme.BaseComposeTheme
import com.achmad.baseandroid.theme.component.ThemePreviewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchPostList()

        setContent {
            BaseComposeTheme {
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

    private fun goToUserDetail(postItem: PostItem) {
        startActivity(
            DetailActivity.createIntent(
                this,
                postItem
            )
        )
    }
}
