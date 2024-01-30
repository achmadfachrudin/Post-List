package com.achmad.baseandroid.service.data

import com.achmad.baseandroid.service.data.entity.PostItemEntity
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class AppRemote @Inject constructor(
    private val service: AppService
) {

    suspend fun fetchPostList(): ApiResponse<List<PostItemEntity>> = service.fetchPostList()
}
