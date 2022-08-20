package com.bchmsl.homework16.model

import com.squareup.moshi.Json

data class ApiResponse(
    val page: Int?,
    @field:Json(name = "per_page")
    val perPage: Int?,
    val total: Int?,
    @field:Json(name = "total_pages")
    val totalPages: Int?,
    val data: List<User>
) {
    data class User(
        val id: Int?,
        val email: String?,
        @field:Json(name = "first_name")
        val firstName: String?,
        @field:Json(name = "last_name")
        val lastName: String?,
        val avatar: String?
    )
}
