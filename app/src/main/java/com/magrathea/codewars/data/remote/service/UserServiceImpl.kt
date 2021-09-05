package com.magrathea.codewars.data.remote.service

import com.magrathea.codewars.data.remote.CodeWarsApi
import com.magrathea.codewars.data.remote.entity.UserDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val codeWarsApi: CodeWarsApi,
) : UserService {
    override suspend fun findUserByUserName(username: String): Flow<List<UserDto>> {
        return codeWarsApi.findUserByUserName(username)
    }
}