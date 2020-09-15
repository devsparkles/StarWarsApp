/* Licensed under BBOXX Ltd Licence*/
package com.devsparkle.starwarsapp.data.local.converters

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

/**
 * Type converters to allow Room to reference complex data types.
 */
class DateConverter {
    @TypeConverter
    fun dateToString(date: Date): String {
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
            return sdf.format(date)
        } catch (e: Exception) {
            return ""
        }
    }

    @TypeConverter
    fun stringToDate(value: String): Date? {
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
            return sdf.parse(value)
        } catch (e: Exception) {
            return null
        }
    }
}