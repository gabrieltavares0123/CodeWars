package com.magrathea.codewars.data.mapper

import com.magrathea.codewars.data.local.entity.UserEntity
import com.magrathea.codewars.data.remote.entity.UserDto
import com.magrathea.codewars.domain.model.User

fun UserDto.toUserEntity(): UserEntity {
    return UserEntity(
        userName = this.userName,
        name = this.name,
        honor = this.honor,
        clan = this.clan,
        leaderboardPosition = this.leaderboardPosition,
        skills = this.skills,
        ranksEntity = this.ranksDto?.toRanksEntity(),
    )
}

fun UserEntity.toDomainUser(): User {
    return User(
        userName = this.userName,
        name = this.name,
        honor = this.honor,
        clan = this.clan,
        leaderboardPosition = this.leaderboardPosition,
        skills = this.skills,
        ranks = this.ranksEntity?.toRanksDomain(),
    )
}