package com.magrathea.codewars.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.model.AuthoredChallenge

@Dao
interface AuthoredChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(authoredChallenge: List<AuthoredChallenge>)

    @Query(value = "SELECT * FROM AuthoredChallenge WHERE userNameAuthor LIKE :username")
    suspend fun allAuthoredChallengesByUserName(username: String): List<AuthoredChallenge>
}