package com.achmad.feature.post.data.mapper

import com.achmad.feature.post.data.entity.PostItemEntity
import com.achmad.feature.post.data.model.PostItem
import org.junit.Assert
import org.junit.Test

internal class PostMapperKtTest {

    @Test
    fun `map post entity to post item`() {
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
