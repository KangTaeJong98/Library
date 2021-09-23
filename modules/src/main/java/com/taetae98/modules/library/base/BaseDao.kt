package com.taetae98.modules.library.base

import androidx.room.*

@Dao
interface BaseDao<T: Any> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dto: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg dto: T): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dto: Collection<T>): LongArray

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(dto: T): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(vararg dto: T): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(dto: Collection<T>): Int

    @Delete
    suspend fun delete(dto: T): Int

    @Delete
    suspend fun delete(vararg dto: T): Int

    @Delete
    suspend fun delete(dto: Collection<T>): Int
}