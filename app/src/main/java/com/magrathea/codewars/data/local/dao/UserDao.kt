package com.magrathea.codewars.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.data.local.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(user: User)

    @Query(value = "SELECT * FROM User WHERE username = :username")
    suspend fun findUserByUserName(username: String): User?

    @Query(value = "SELECT * FROM User ORDER BY honor DESC LIMIT 5")
    suspend fun fiveUsersOrderedByHonor(): List<User>

    @Query(value = "SELECT * FROM User ORDER BY searchDate DESC LIMIT 5")
    suspend fun fiveLastSearchedUsersBySearchDate(): List<User>
}