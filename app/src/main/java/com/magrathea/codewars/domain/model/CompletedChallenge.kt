package com.magrathea.codewars.domain.model

data class CompletedChallenge(
    var id: String,
    var name: String? = null,
    var slug: String? = null,
    var completedAt: String? = null,
    var completedLanguages: List<String>? = emptyList(),
)
