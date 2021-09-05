package com.magrathea.codewars.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magrathea.codewars.data.local.dao.UserDao
import com.magrathea.codewars.data.mapper.toDomainUser
import com.magrathea.codewars.data.mapper.toUserEntity
import com.magrathea.codewars.data.remote.service.UserService
import com.magrathea.codewars.domain.model.User
import com.magrathea.codewars.domain.repository.SortType
import com.magrathea.codewars.domain.repository.UserRepository
import com.magrathea.codewars.util.Resource
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService,
) : UserRepository {
    override suspend fun findUserByUserName(username: String): LiveData<Resource<List<User>>> {
        userService.findUserByUserName(username).collect { userDto ->
            userDao.save(userDto.map { it.toUserEntity() })
        }

        val domainUser = userDao.findUserByUserName(username)?.let { userEntityList ->
            userEntityList.map { it.toDomainUser() }
        }

        return MutableLiveData(Resource.Success(domainUser))
    }

    override suspend fun findAllBySortType(sortType: SortType): LiveData<Resource<List<User>>> {
        val usersListResult = when (sortType) {
            SortType.HONOR -> {
                userDao.findAllUsersOrderedByHonor().map { it.toDomainUser() }
            }
            SortType.SEARCH_DATE -> {
                userDao.findAllUsersOrderedBySearchDate().map { it.toDomainUser() }
            }
        }

        val usersListResource = Resource.Success(usersListResult)

        return MutableLiveData(usersListResource)
    }
}

