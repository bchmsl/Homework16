package com.bchmsl.homework16.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitProvider {
    private const val BASE_URL = "https://reqres.in/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun provideClient(): ApiClient = retrofit.create(ApiClient::class.java)
}