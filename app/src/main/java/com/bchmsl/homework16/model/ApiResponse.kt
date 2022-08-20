package com.bchmsl.homework16.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class ApiResponse(
    val page: Int?,
    @field:SerializedName("per_page")
    val perPage: Int?,
    val total: Int?,
    @field:SerializedName("total_pages")
    val totalPages: Int?,
    val data: List<User>
) {
    data class User(
        val id: Int?,
        val email: String?,
        @field:SerializedName("first_name")
        val firstName: String?,
        @field:SerializedName("last_name")
        val lastName: String?,
        val avatar: String?
    )
}
