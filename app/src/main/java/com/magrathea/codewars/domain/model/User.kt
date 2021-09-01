package com.magrathea.codewars.domain.model

import com.magrathea.codewars.data.local.entity.LanguageEntity

data class User(
    val userName: String,
    val name: String? = null,
    val honor: Int? = 0,
    val clan: String? = null,
    val leaderboardPosition: Int? = 0,
    val skills: List<String>? = emptyList(),
    val ranks: Ranks? = null,
    val bestLanguageEntity: LanguageEntity? = null,
    val searchDate: Long? = null,
)
