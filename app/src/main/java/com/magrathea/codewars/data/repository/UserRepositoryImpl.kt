package com.magrathea.codewars.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magrathea.codewars.data.local.dao.UserDao
import com.magrathea.codewars.data.remote.service.UserService
import com.magrathea.codewars.domain.repository.SortType
import com.magrathea.codewars.domain.repository.UserRepository
import com.magrathea.codewars.model.User
import com.magrathea.codewars.util.Resource
import java.lang.System.currentTimeMillis
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService,
) : UserRepository {
    override suspend fun findUserByUserName(username: String): LiveData<Resource<User>> {
        val searchedMember = userService.findUserByUserName(username)
        searchedMember.searchDate = currentTimeMillis()
        userDao.save(searchedMember)

        val fromLocalDataSource = userDao.findUserByUserName(username)

        return MutableLiveData(Resource.Success(fromLocalDataSource))
    }

    override suspend fun findLastFiveUsersBySortType(sortType: SortType): LiveData<Resource<List<User>>> {
        val users = when (sortType) {
            SortType.HONOR -> {
                userDao.findLastFiveUsersOrderedByHonor()
            }
            SortType.SEARCH_DATE -> {
                userDao.findLastFiveLastUsersOrderedBySearchDate()
            }
        }

        return MutableLiveData(Resource.Success(users))
    }
}

