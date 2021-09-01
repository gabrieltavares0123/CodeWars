package com.magrathea.codewars.data.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.data.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(user: User)

    @Query(value = "SELECT * FROM User.LocalUser WHERE username = :username")
    suspend fun findUserByUserName(username: String): User?

    @Query(value = "SELECT * FROM User.LocalUser ORDER BY honor DESC LIMIT 5")
    suspend fun fiveUsersOrderedByHonor(): DataSource.Factory<Int, User.LocalUser>

    @Query(value = "SELECT * FROM User.LocalUser ORDER BY searchDate DESC LIMIT 5")
    suspend fun fiveLastSearchedUsersBySearchDate(): DataSource.Factory<Int, User.LocalUser>
}