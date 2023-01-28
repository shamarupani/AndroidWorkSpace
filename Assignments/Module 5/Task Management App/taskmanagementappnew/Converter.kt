package com.example.taskmanagementappnew

import androidx.room.TypeConverter
import java.util.*

class Converter
{
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
    }

