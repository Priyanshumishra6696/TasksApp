package com.example.tasksapp.roomdb

import android.app.Application
import androidx.room.Room

class DataBaseInstance : Application() {
    companion object{
        lateinit var taskDatabase: TaskDatabase
    }

    override fun onCreate() {
        super.onCreate()
        taskDatabase = Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            TaskDatabase.Name
        ).build()
    }
}