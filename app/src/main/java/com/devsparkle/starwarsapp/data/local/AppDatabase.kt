package com.devsparkle.starwarsapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devsparkle.starwarsapp.data.local.converters.CalendarConverter
import com.devsparkle.starwarsapp.data.local.converters.DateConverter
import com.devsparkle.starwarsapp.data.local.dao.PeopleDao
import com.devsparkle.starwarsapp.data.local.entities.PeopleEntity

@Database(entities = [PeopleEntity::class], version = 1, exportSchema = false)
@TypeConverters(CalendarConverter::class, DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun peopleDao(): PeopleDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "characters")
                .fallbackToDestructiveMigration()
                .build()
    }

}