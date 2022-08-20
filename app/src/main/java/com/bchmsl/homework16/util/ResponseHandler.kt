package com.bchmsl.homework16.util

import androidx.paging.PagingData
import com.bchmsl.homework16.model.ApiResponse

sealed class ResponseHandler(val isLoading: Boolean = false) {
    class Success(val data: PagingData<ApiResponse.User>) : ResponseHandler()
    class Error(val error: String) : ResponseHandler()
    class Loading() : ResponseHandler(true)
}
