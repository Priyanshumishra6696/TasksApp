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

    @Query("select * from ListEntity order by listId")
    fun getAllList() : LiveData<List<ListEntity>>

    @Upsert
    suspend fun addList(listEntity: ListEntity)

    @Query("delete from ListEntity where listId=:listId")
    suspend fun deleteList(listId : Int)

    @Upsert
    suspend fun addTask(TaskEntity:TaskEntity)

    @Query("Delete from TaskEntity where id=:id")
    suspend fun deleteTask(id:Int)

}