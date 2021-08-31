package com.magrathea.codewars.data

sealed class NetworkResult<T>(
    val totalPages: Int? = 0,
    val totalItems: Int? = 0,
    val data: T? = null,
    val message: String? = null,
) {
    class Sucess<T>(
        totalPages: Int = 1, totalItems: Int = 1, data: T
    ) : NetworkResult<T>(
        totalPages = totalPages,
        totalItems = totalItems,
        data = data
    )

    class Error<T>(
        message: String?,
        data: T? = null
    ) : NetworkResult<T>(
        data = data,
        message = message
    )

    class Loading<T> : NetworkResult<T>()
}