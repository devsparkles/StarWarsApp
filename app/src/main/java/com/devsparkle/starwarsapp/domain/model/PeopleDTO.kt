package com.devsparkle.starwarsapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class PeopleDTO(
    val name: String,
    val height: String,
    val mass: String,
    val created: Date
) : Parcelable