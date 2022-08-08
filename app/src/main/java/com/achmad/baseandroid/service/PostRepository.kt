package com.achmad.baseandroid.service

import androidx.annotation.WorkerThread
import com.achmad.common.ApiResult
import com.achmad.feature.post.data.mapper.toPostItem
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remote: PostRemote
) {

    @WorkerThread
    fun fetchPostList(
        filter: String
    ) = flow {
        emit(ApiResult.Loading)

        val response = remote.fetchPostList()

        response.suspendOnSuccess {
            val posts = data
                .filter { it.title.contains(filter) }
                .map {
                    it.toPostItem()
                }
            emit(ApiResult.Success(posts))
        }.suspendOnError {
            // handles error cases
            emit(ApiResult.Error(this.toString()))
        }.suspendOnException {
            // handles exceptional cases
            emit(ApiResult.Error(this.toString()))
        }
    }.flowOn(Dispatchers.IO)
}
