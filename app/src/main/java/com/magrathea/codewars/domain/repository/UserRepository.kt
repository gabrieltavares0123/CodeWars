package com.magrathea.codewars.domain.repository

import com.magrathea.codewars.domain.model.User

interface UserRepository {
    suspend fun findUserByUserName(username: String): User?
}