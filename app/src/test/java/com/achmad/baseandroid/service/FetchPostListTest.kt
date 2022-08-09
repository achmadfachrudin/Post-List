package com.achmad.baseandroid.service

import com.achmad.common.ApiResult
import com.achmad.feature.post.data.entity.PostItemEntity
import com.skydoves.sandwich.ApiResponse
import io.mockk.coEvery
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class FetchPostListTest : PostRepositoryTest() {

    @Test
    fun `fetchPostlist success should return posts`() {
        val result = listOf(
            entity,
            entity,
            entity
        )

        coEvery {
            remote.fetchPostList()
        } returns ApiResponse.Success(Response.success(result))

        val actual = runBlocking { repository.fetchPostList("").last() }

        Assert.assertEquals(ApiResult.Success(result).status, actual.status)
        Assert.assertEquals(3, actual.data?.size)
    }

    @Test
    fun `fetchPostlist error should return error`() {
        val result = Response.error<List<PostItemEntity>>(
            400,
            "".toResponseBody()
        )

        coEvery {
            remote.fetchPostList()
        } returns ApiResponse.Failure.Error(result)

        val actual = runBlocking { repository.fetchPostList("").last() }

        Assert.assertEquals(ApiResult.Error("").status, actual.status)
    }
}
