package com.achmad.baseandroid.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.achmad.baseandroid.core.network.ApiResult
import com.achmad.baseandroid.service.data.AppRepository
import com.achmad.baseandroid.service.data.model.PostItem
import com.achmad.baseandroid.service.domain.GetPostListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase
) : ViewModel() {

    val uiMutableState = MutableStateFlow<ApiResult<List<PostItem>>>(ApiResult.Loading)
    val uiState: StateFlow<ApiResult<List<PostItem>>> = uiMutableState

    fun fetchPostList(filter: String = "") {
        viewModelScope.launch {
            getPostListUseCase(filter).collectLatest {
                uiMutableState.value = it
            }
        }
    }
}
