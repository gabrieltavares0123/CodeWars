package com.magrathea.codewars.domain.model

data class Ranks(
    var overall: Int? = 0,
    var languages: Map<String, Int>? = emptyMap()
)
