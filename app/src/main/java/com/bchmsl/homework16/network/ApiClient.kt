package com.bchmsl.homework16.network

import com.bchmsl.homework16.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("api/users")
    suspend fun getUsers(@Query("page") page: Int = 1): Response<ApiResponse>
}