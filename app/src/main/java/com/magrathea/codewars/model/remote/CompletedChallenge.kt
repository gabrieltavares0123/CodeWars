package com.magrathea.codewars.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompletedChallenge(
    val id: String,
    val name: String,
    val slug: String,
    val completedAt: String,
    val completedLanguages: List<String> = emptyList(),
) : Parcelable
