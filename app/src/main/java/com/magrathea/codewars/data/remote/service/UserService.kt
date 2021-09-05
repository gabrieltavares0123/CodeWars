package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.dto.UserDto
import kotlinx.coroutines.flow.Flow

interface UserService {
    suspend fun findUserByUserName(username: String): Flow<List<UserDto>>
}