package com.taetae98.library.dao

import androidx.room.Dao
import com.taetae98.library.dto.TestDTO
import com.taetae98.module.base.BaseDao

@Dao
interface TestDAO : BaseDao<TestDTO>