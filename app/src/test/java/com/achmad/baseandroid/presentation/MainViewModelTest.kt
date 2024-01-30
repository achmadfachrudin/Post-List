package com.achmad.baseandroid.presentation

import com.achmad.baseandroid.service.data.AppRepository
import com.achmad.common.ApiResult
import com.achmad.feature.post.data.model.PostItem
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class MainViewModelTest {

    private val repository = mockk<AppRepository>()

    private val viewModel = MainViewModel(
        repository
    )

    private val post = PostItem(
        id = 111,
        userId = 1,
        title = "title",
        body = "body"
    )

    @Before
    fun setup() {
        clearAllMocks()
    }

    @Test
    fun `fetchPostList success should return posts`() = runTest {
        val postList = listOf(post)

        val result = ApiResult.Success(postList)
        coEvery {
            repository.fetchPostList("")
        } returns flowOf(result)

        val collectJob = launch(UnconfinedTestDispatcher()) {
            repository.fetchPostList("").collectLatest { viewModel.uiMutableState.value = it }
        }

        Assert.assertEquals(result.status, viewModel.uiState.value.status)

        collectJob.cancel()
    }
}
