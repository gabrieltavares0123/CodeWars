package com.magrathea.codewars.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: User)

    @Query(value = "SELECT * FROM User WHERE username = :username")
    suspend fun findUserByUserName(username: String): User

    @Query(value = "SELECT * FROM User ORDER BY honor DESC LIMIT 5")
    suspend fun findLastFiveUsersOrderedByHonor(): List<User>

    @Query(value = "SELECT * FROM User ORDER BY searchDate DESC LIMIT 5")
    suspend fun findLastFiveLastUsersOrderedBySearchDate(): List<User>
}