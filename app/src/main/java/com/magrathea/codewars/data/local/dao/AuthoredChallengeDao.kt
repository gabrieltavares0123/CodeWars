package com.magrathea.codewars.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.magrathea.codewars.data.local.entity.AuthoredChallengeEntity

@Dao
interface AuthoredChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(authoredChallengeEntity: AuthoredChallengeEntity)

    @Query(value = "SELECT * FROM AuthoredChallengeEntity WHERE userNameAuthor LIKE :username")
    fun allAuthoredChallengesByUserName(username: String): PagingSource<Int, AuthoredChallengeEntity>
}