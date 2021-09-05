package com.magrathea.codewars.model

data class ChallengeResponse<T>(
    val totalPages: Int? = 0,
    val totalItems: Int? = 0,
    val data: List<T>
)