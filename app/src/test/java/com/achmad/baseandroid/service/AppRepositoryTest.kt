package com.achmad.baseandroid.service

import com.achmad.baseandroid.service.data.AppRemote
import com.achmad.baseandroid.service.data.AppRepository
import com.achmad.feature.post.data.entity.PostItemEntity
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.Before

open class AppRepositoryTest {

    protected val remote: AppRemote = mockk()

    protected val repository = AppRepository(
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
