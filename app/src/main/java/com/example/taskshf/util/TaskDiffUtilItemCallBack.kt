package com.example.taskshf.util

import androidx.recyclerview.widget.DiffUtil
import com.example.taskshf.database.Task

class TaskDiffUtilItemCallBack: DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = (oldItem.taskId == newItem.taskId)

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = (oldItem == newItem)
}