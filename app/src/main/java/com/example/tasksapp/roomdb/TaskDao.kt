package com.example.tasksapp.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.tasksapp.TaskViewModel

@Dao
interface TaskDao {

    @Query("Select * from TaskEntity order by id")
    fun getAllTask() : LiveData<List<TaskEntity>>

    @Upsert
    suspend fun addTask(TaskEntity:TaskEntity)

    @Query("Delete from TaskEntity where id=:id")
    suspend fun deleteTask(id:Int)

}