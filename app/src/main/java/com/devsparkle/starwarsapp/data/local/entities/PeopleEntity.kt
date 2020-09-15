package com.devsparkle.starwarsapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "peoples")
data class PeopleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long,

    var name: String,
    var height: Long,
    var mass: Long,
    var create: Date

) {
    override fun toString() = name
}
