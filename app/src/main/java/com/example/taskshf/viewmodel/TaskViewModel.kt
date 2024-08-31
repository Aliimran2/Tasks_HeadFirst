package com.example.taskshf.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.taskshf.database.Task
import com.example.taskshf.database.TaskDao
import kotlinx.coroutines.launch


class TaskViewModel(val dao: TaskDao):ViewModel() {

    var newTaskName = ""

    val _tasks = dao.getAll()
    val taskString = _tasks.map { tasks ->
        formatTasks(tasks)
    }

    fun formatTasks(tasks: List<Task>):String{
        return tasks.fold(""){
            str, item -> str + "\n" + formatTask(item)
        }
    }

    fun formatTask(task:Task):String {
        var str = "ID: ${task.taskId}"
        str+="\n"+"Name: ${task.taskName}"
        str+="\n"+"Status: ${task.taskDone}" +"\n"
        return str
    }

    fun addTask(){
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }


}