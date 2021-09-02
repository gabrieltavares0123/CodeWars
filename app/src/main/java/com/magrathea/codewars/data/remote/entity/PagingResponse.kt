package com.magrathea.codewars.data.remote.entity

data class PagingResponse<T>(
    val totalPages: Int = 0,
    val totalItems: Int = 0,
    val data: T,
)