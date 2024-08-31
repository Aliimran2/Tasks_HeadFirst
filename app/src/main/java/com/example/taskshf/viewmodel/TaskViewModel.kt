package com.example.taskshf.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskshf.database.Task
import com.example.taskshf.database.TaskDao
import kotlinx.coroutines.launch

class TaskViewModel(val dao: TaskDao):ViewModel() {

    var newTaskName = ""

    fun addTask(){
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }
}