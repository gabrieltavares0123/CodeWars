package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.entity.User
import com.magrathea.codewars.data.remote.CodeWarsApi
import retrofit2.awaitResponse
import javax.inject.Inject

class UserService @Inject constructor(
    private val codeWarsApi: CodeWarsApi
){
    suspend fun findUserByUserName(username: String): User.RemoteUser? {
        return codeWarsApi.findUserByUserName(username).awaitResponse().body()
    }
}