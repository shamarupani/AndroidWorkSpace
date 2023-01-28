package com.example.taskmanagementappnew

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [EntityClass::class], version = 1)
@TypeConverters(Converter::class)
abstract class DatabaseClass : RoomDatabase()
{
        abstract fun dao():DaoClass
}