package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.entity.UserDto
import kotlinx.coroutines.flow.Flow

interface UserService {
    suspend fun findUserByUserName(username: String): Flow<List<UserDto>>
}