package com.magrathea.codewars.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magrathea.codewars.data.local.dao.UserDao
import com.magrathea.codewars.data.remote.service.UserService
import com.magrathea.codewars.domain.repository.SortType
import com.magrathea.codewars.domain.repository.UserRepository
import com.magrathea.codewars.model.BestLanguage
import com.magrathea.codewars.model.User
import com.magrathea.codewars.util.Resource
import java.util.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService,
) : UserRepository {
    override suspend fun findUserByUserName(username: String): LiveData<Resource<List<User>>> {
        return try {
            var searchedMember = userDao.findUserByUserName(username)

            searchedMember.let {
                searchedMember = userService.findUserByUserName(username)
                searchedMember.searchDate = Date().time
                searchedMember.bestLanguage = getBestLanguage(searchedMember)
            }
            userDao.save(searchedMember)

            MutableLiveData(Resource.Success(listOf(searchedMember)))
        } catch (ex: Throwable) {
            MutableLiveData(Resource.Error(ex))
        }
    }

    private fun getBestLanguage(user: User): BestLanguage? {
        val languages = user.ranks?.languages
        val entry = languages?.entries?.maxByOrNull { it.value.score }
        return if (entry != null) BestLanguage(entry.key, entry.value.score) else null
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

