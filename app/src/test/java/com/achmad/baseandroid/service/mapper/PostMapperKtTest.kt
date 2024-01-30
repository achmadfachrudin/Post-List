package com.achmad.baseandroid.service.mapper

import com.achmad.baseandroid.service.data.entity.PostItemEntity
import com.achmad.baseandroid.service.data.mapper.toPostItem
import com.achmad.baseandroid.service.data.model.PostItem
import org.junit.Assert
import org.junit.Test

internal class PostMapperKtTest {

    @Test
    fun `test toPostItem()`() {
        val entity = PostItemEntity(
            id = 123,
            userId = 1234,
            title = "title",
            body = "body"
        )

        val actual = entity.toPostItem()

        val expected = PostItem(
            id = 123,
            userId = 1234,
            title = "title",
            body = "body"
        )

        Assert.assertEquals(expected, actual)
    }
}
