package com.magrathea.codewars.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(userEntity: List<UserEntity>)

    @Query(value = "SELECT * FROM UserEntity WHERE username = :username")
    suspend fun findUserByUserName(username: String): List<UserEntity>?

    @Query(value = "SELECT * FROM UserEntity ORDER BY honor")
    suspend fun findAllUsersOrderedByHonor(): List<UserEntity>

    @Query(value = "SELECT * FROM UserEntity ORDER BY searchDate")
    suspend fun findAllUsersOrderedBySearchDate(): List<UserEntity>
}