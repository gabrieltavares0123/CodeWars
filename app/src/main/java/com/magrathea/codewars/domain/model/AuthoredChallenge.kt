package com.magrathea.codewars.domain.model

data class AuthoredChallenge(
    var id: String,
    var name: String? = null,
    var description: String? = null,
    var rank: Int? = null,
    var rankName: String? = null,
    var tags: List<String>? = emptyList(),
    var languages: List<String>? = emptyList(),
)