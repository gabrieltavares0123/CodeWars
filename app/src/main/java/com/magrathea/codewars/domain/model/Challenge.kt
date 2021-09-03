package com.magrathea.codewars.domain.model

data class Challenge(
    val id: String,
    val name: String,
    val type: ChallengeType,
)