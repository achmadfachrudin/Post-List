package com.achmad.baseandroid.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.achmad.baseandroid.service.PostRepository
import com.achmad.common.ApiResult
import com.achmad.feature.post.data.model.PostItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    val uiMutableState = MutableStateFlow<ApiResult<List<PostItem>>>(ApiResult.Loading)
    val uiState: StateFlow<ApiResult<List<PostItem>>> = uiMutableState

    fun fetchPostList(filter: String = "") {
        viewModelScope.launch {
            postRepository.fetchPostList(filter).collectLatest {
                uiMutableState.value = it
            }
        }
    }
}
