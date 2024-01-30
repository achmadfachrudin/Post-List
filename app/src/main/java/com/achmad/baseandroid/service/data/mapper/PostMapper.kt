package com.achmad.baseandroid.service.data.mapper

import com.achmad.baseandroid.service.data.entity.PostItemEntity
import com.achmad.baseandroid.service.data.model.PostItem

fun PostItemEntity.toPostItem(): PostItem {
    return PostItem(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}
