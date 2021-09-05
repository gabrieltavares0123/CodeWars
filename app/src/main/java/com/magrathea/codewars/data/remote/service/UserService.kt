package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.model.User

interface UserService {
    suspend fun findUserByUserName(username: String): User
}