package com.magrathea.codewars.data.repository

import com.magrathea.codewars.data.local.dao.UserDao
import com.magrathea.codewars.data.local.entity.RanksEntity
import com.magrathea.codewars.data.local.entity.UserEntity
import com.magrathea.codewars.data.remote.entity.RanksDto
import com.magrathea.codewars.data.remote.entity.UserDto
import com.magrathea.codewars.data.remote.service.UserService
import com.magrathea.codewars.domain.model.Ranks
import com.magrathea.codewars.domain.model.User
import com.magrathea.codewars.domain.repository.UserRepository
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService,
) : UserRepository {
    override suspend fun findUserByUserName(username: String): User? {
        userService.findUserByUserName(username).collect { userDto ->
            userDao.save(userDto.toUserEntity())
        }

        return userDao.findUserByUserName(username)?.toDomainUser()
    }
}

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
        ranks = this.ranksEntity?.toRanks(),
    )
}

fun RanksDto.toRanksEntity(): RanksEntity {
    return RanksEntity(
        overall = this.overall,
        languages = this.languages
    )
}

fun RanksEntity.toRanks(): Ranks {
    return Ranks(
        overall = this.overall,
        languages = this.languages,
    )
}