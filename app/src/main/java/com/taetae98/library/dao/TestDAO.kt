package com.taetae98.library.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.taetae98.library.dto.TestDTO
import com.taetae98.modules.library.base.BaseDao

@Dao
interface TestDAO : BaseDao<TestDTO> {
    @Query("SELECT * FROM TestDTO")
    fun findAllLiveData(): LiveData<List<TestDTO>>
}