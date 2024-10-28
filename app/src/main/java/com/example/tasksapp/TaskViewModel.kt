package com.example.tasksapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasksapp.roomdb.DataBaseInstance
import com.example.tasksapp.roomdb.ListEntity
import com.example.tasksapp.roomdb.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {


    val taskDao = DataBaseInstance.taskDatabase.getTaskDao()
    val taskList : LiveData<List<TaskEntity>> = taskDao.getAllTask()
    val listList : LiveData<List<ListEntity>> = taskDao.getAllList()



    fun addTask(taskEntered :String){
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.addTask(TaskEntity(taskEntered = taskEntered, listId = 1))
        }
    }

    fun addList(listName : String){
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.addList(listEntity = ListEntity(listName = listName))
        }
    }


    fun deleteTask(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.deleteTask(id)
        }
    }
}