package com.example.taskmanagementappnew

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface DaoClass
{
    @Insert
    suspend  fun insertTask(entityClass: EntityClass?):Long

    @Query("Select * from todo where isFinished == 0")
     suspend fun getTasks(): List<EntityClass>

    @Query("Update todo Set isFinished = 1 where id=:uid")
    suspend fun finishTask(uid:Long)

    @Query("Delete from todo where id=:uid")
   suspend fun deleteTask(uid:Long)

    @Query("Delete from todo")
    suspend fun deleteAll()
    @Update
    suspend fun updateTask(entityClass: EntityClass?)

    @Delete
    suspend fun deleteTask(entityClass: EntityClass?)



 /*   @Query("Select * from todo")
    suspend fun getTasks():List<EntityClass>*/

   /* @Query("SELECT * FROM todo ORDER BY date ASC")
    open fun sorttask(): MutableList<CardInfo?>?

*/
  /*  @Query("SELECT * FROM todo ORDER BY date ASC")
    open fun sortingDate(targetDate: Date): MutableList<CardInfo?>?

*/
}