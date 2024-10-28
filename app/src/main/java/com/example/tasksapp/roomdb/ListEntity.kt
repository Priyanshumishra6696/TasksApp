package com.example.tasksapp.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListEntity(
    @PrimaryKey(autoGenerate = true)
    val listId : Int = 0 ,
    val listName : String
)
