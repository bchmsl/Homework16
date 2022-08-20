package com.bchmsl.homework16.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.bchmsl.homework16.model.ApiResponse
import com.bchmsl.homework16.network.ApiClient
import com.bchmsl.homework16.network.RetrofitProvider
import com.bchmsl.homework16.paging.UsersPagingSource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    companion object {
        private const val NETWORK_PAGE_SIZE = 2
        private val pagingSource = {
            UsersPagingSource(RetrofitProvider.provideClient())
        }
    }


    private val _responseFlow = MutableSharedFlow<PagingData<ApiResponse.User>>()
    val responseFlow get() = _responseFlow.asSharedFlow()

    fun getUsers() =
        viewModelScope.launch {
            val retrofitClient = RetrofitProvider.provideClient()
            providePager(retrofitClient).cachedIn(viewModelScope).collect {
                _responseFlow.emit(it)
            }
        }

    private fun providePager(retrofitClient: ApiClient) =
        Pager(
            config = PagingConfig(NETWORK_PAGE_SIZE),
            pagingSourceFactory = pagingSource
        ).flow
}