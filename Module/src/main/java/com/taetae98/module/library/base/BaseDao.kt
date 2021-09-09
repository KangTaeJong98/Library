package com.taetae98.module.library.base

import androidx.room.*

@Dao
interface BaseDao<T: Any> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dto: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg dto: T): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dto: List<T>): LongArray

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(dto: T): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg dto: T): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(dto: List<T>): Int

    @Delete
    fun delete(dto: T): Int

    @Delete
    fun delete(vararg dto: T): Int

    @Delete
    fun delete(dto: List<T>): Int
}