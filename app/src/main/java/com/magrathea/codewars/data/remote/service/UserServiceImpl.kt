package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.data.repository.exception.UserNotFoundException
import com.magrathea.codewars.model.User
import retrofit2.awaitResponse
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi,
) : UserService {
    override suspend fun findUserByUserName(username: String): User {
        val user = codeWarsApi.findUserByUserName(username).awaitResponse().body()
        return user ?: throw UserNotFoundException("User not found.")
    }
}