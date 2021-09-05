package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.model.User
import retrofit2.await
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi,
) : UserService {
    override suspend fun findUserByUserName(username: String): User {
        return codeWarsApi.findUserByUserName(username).await()
    }
}