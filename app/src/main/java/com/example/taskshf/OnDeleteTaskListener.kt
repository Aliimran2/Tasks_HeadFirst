package com.example.taskshf

import com.example.taskshf.database.Task

interface OnDeleteTaskListener {
    fun onTaskDelete(task: Task)
}