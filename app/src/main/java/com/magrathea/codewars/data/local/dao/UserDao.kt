package com.magrathea.codewars.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(userEntity: UserEntity)

    @Query(value = "SELECT * FROM UserEntity WHERE username = :username")
    suspend fun findUserByUserName(username: String): UserEntity?

    @Query(value = "SELECT * FROM UserEntity ORDER BY honor DESC LIMIT 5")
    suspend fun fiveUsersOrderedByHonor(): List<UserEntity>

    @Query(value = "SELECT * FROM UserEntity ORDER BY searchDate DESC LIMIT 5")
    suspend fun fiveLastSearchedUsersBySearchDate(): List<UserEntity>
}