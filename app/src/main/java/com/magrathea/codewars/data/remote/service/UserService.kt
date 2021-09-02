package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.entity.UserDto
import com.magrathea.codewars.data.remote.CodeWarsApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserService @Inject constructor(
    private val codeWarsApi: CodeWarsApi,
){
    suspend fun findUserByUserName(username: String): Flow<UserDto> {
        return codeWarsApi.findUserByUserName(username)
    }
}