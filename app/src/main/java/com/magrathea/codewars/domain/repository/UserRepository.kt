package com.magrathea.codewars.domain.repository

import androidx.lifecycle.LiveData
import com.magrathea.codewars.domain.model.User
import com.magrathea.codewars.util.Resource

interface UserRepository {
    suspend fun findUserByUserName(username: String): LiveData<Resource<List<User>>>
    suspend fun findAllBySortType(sortType: SortType): LiveData<Resource<List<User>>>
}