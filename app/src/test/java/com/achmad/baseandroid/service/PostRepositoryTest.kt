package com.achmad.baseandroid.service

import com.achmad.feature.post.data.entity.PostItemEntity
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.Before

open class PostRepositoryTest {

    protected val remote: PostRemote = mockk()

    protected val repository = PostRepository(
        remote
    )

    protected val entity = PostItemEntity(
        id = 111,
        userId = 1,
        title = "title",
        body = "body"
    )

    @Before
    fun setup() {
        clearAllMocks()
    }
}
