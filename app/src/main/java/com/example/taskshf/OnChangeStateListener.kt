package com.example.taskshf

import com.example.taskshf.database.Task

interface OnChangeStateListener {
    fun changeState(task:Task)
}