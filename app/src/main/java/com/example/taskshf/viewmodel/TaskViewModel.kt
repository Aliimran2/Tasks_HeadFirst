package com.example.taskshf.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.taskshf.database.Task
import com.example.taskshf.database.TaskDao
import kotlinx.coroutines.launch


class TaskViewModel(val dao: TaskDao):ViewModel() {

    var newTaskName = MutableLiveData<String>()
    val tasks = dao.getAll()

    private val _taskToNavigate = MutableLiveData<Long?>()
    val taskToNavigate : LiveData<Long?> = _taskToNavigate

    fun onTaskClicked(taskId: Long){
        _taskToNavigate.value = taskId
    }

    fun onTaskNavigated(){
        _taskToNavigate.value = null
    }


    fun isDoneTask(task: Task){
        viewModelScope.launch {

            dao.update(task.copy(taskDone = !task.taskDone))
        }
    }



    fun addTask(){
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName.value!!

            dao.insert(task)
            newTaskName.value = ""
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch {
            dao.delete(task)
        }
    }
}