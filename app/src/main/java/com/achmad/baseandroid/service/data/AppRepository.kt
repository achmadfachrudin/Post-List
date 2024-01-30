package com.achmad.baseandroid.service.data

import com.achmad.baseandroid.core.network.ApiResult
import com.achmad.baseandroid.service.data.mapper.toPostItem
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remote: AppRemote
) {

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
            emit(ApiResult.Error(this.toString()))
        }.suspendOnException {
            emit(ApiResult.Error(this.toString()))
        }
    }.flowOn(Dispatchers.IO)
}
