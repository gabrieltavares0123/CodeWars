package com.magrathea.codewars.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(userEntity: UserEntity)

    @Query(value = "SELECT * FROM UserEntity WHERE username = :username")
    fun findUserByUserName(username: String): Flow<UserEntity?>

    @Query(value = "SELECT * FROM UserEntity ORDER BY honor DESC LIMIT 5")
    fun fiveUsersOrderedByHonor(): Flow<List<UserEntity>>

    @Query(value = "SELECT * FROM UserEntity ORDER BY searchDate DESC LIMIT 5")
    fun fiveLastSearchedUsersBySearchDate(): Flow<List<UserEntity>>
}