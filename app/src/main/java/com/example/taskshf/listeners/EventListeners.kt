package com.example.taskshf.listeners

import com.example.taskshf.database.Task

interface EventListeners {
    fun onItemClickListener(task:Task)
    fun onItemLongClickListener(task: Task):Boolean


}