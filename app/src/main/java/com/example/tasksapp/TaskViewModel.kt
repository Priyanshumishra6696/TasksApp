package com.example.tasksapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasksapp.roomdb.DataBaseInstance
import com.example.tasksapp.roomdb.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    var tabs = mutableListOf("Starred","My Tasks")
    var pageCount = tabs.size

    val taskDao = DataBaseInstance.taskDatabase.getTaskDao()
    val taskList : LiveData<List<TaskEntity>> = taskDao.getAllTask()

    fun addTabs(newTab : String){
        tabs.add(newTab)
    }

    fun addTask(taskEntered :String){
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.addTask(TaskEntity(taskEntered = taskEntered))
        }
    }

    fun deleteTask(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.deleteTask(id)
        }
    }
}