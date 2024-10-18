package com.example.tasksapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class] , version = 1)
abstract class TaskDatabase : RoomDatabase(){
    companion object{
        const val Name = "Task_DB"
    }
    abstract fun getTaskDao() : TaskDao
}