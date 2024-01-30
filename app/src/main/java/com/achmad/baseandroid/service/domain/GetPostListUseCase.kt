package com.achmad.baseandroid.service.domain

import com.achmad.baseandroid.core.network.ApiResult
import com.achmad.baseandroid.service.data.AppRepository
import com.achmad.baseandroid.service.data.model.PostItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val repository: AppRepository
) {
    operator fun invoke(filter: String = ""): Flow<ApiResult<List<PostItem>>> {
        return repository.fetchPostList(filter = filter)
    }
}