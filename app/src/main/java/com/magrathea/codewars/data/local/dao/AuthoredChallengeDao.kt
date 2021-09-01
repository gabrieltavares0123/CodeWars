package com.magrathea.codewars.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.data.local.entity.AuthoredChallenge

@Dao
interface AuthoredChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(authoredChallenge: AuthoredChallenge)

    @Query(value = "SELECT * FROM AuthoredChallenge WHERE userNameAuthor LIKE :username")
    fun allAuthoredChallengesByUserName(username: String): PagingSource<Int, AuthoredChallenge>
}