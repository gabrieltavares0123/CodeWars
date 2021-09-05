package com.magrathea.codewars.data.remote.dto

data class PagingResponse<T>(
    val totalPages: Int = 0,
    val totalItems: Int = 0,
    val data: T,
)