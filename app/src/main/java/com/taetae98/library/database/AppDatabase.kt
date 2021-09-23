package com.taetae98.library.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.taetae98.library.dao.TestDAO
import com.taetae98.library.dto.TestDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [TestDTO::class], views = [], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "test.db"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .build()
                    .also {
                        instance = it
                    }
            }
        }
    }

    abstract fun dao(): TestDAO
}