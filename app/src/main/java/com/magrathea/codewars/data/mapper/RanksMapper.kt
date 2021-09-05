package com.magrathea.codewars.data.mapper

import com.magrathea.codewars.data.local.entity.RanksEntity
import com.magrathea.codewars.data.remote.entity.RanksDto
import com.magrathea.codewars.domain.model.Ranks

fun RanksDto.toRanksEntity(): RanksEntity {
    return RanksEntity(
        overall = this.overall,
        languages = this.languages
    )
}

fun RanksEntity.toRanksDomain(): Ranks {
    return Ranks(
        overall = this.overall,
        languages = this.languages,
    )
}