package com.magrathea.codewars.domain.repository

import com.magrathea.codewars.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun findUserByUserName(username: String): Flow<User?>
}