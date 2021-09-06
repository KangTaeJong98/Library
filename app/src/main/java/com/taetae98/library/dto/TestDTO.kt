package com.taetae98.library.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val data: String
)