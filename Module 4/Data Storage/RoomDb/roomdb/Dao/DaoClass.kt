package com.example.roomdb.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdb.Entity.User

@Dao
interface DaoClass
{
    @Insert
    fun addUser(user: User?)

    @Query("select * from users")
    fun getUsers(): MutableList<User>

    @Delete
    fun deleteUser(user: User?)

    @Update
    fun updateUser(user: User?)

}