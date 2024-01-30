package com.achmad.baseandroid.service.data

import com.achmad.baseandroid.service.data.entity.PostItemEntity
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface AppService {

    @GET("posts")
    suspend fun fetchPostList(): ApiResponse<List<PostItemEntity>>
}
