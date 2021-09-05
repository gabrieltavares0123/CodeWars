package com.magrathea.codewars.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompletedChallengeDto(
    var id: String,
    var name: String? = null,
    var slug: String? = null,
    var completedAt: String? = null,
    var completedLanguages: List<String>? = emptyList(),
): Parcelable