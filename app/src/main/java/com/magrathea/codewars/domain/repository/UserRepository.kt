package com.magrathea.codewars.domain.repository

import androidx.lifecycle.LiveData
import com.magrathea.codewars.model.User
import com.magrathea.codewars.util.Resource

interface UserRepository {
    suspend fun findUserByUserName(username: String): LiveData<Resource<User>>
    suspend fun findLastFiveUsersBySortType(sortType: SortType): LiveData<Resource<List<User>>>
}