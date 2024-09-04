package com.example.taskshf.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskshf.listeners.EventListeners
import com.example.taskshf.database.Task
import com.example.taskshf.databinding.TaskItemBinding
import com.example.taskshf.util.TaskDiffUtilItemCallBack

class TaskItemAdapter(private val listener: EventListeners) :
    ListAdapter<Task, TaskItemAdapter.TaskVH>(TaskDiffUtilItemCallBack()) {

    class TaskVH(private val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

        var toggle = false
        fun bind(task: Task, listener: EventListeners) {
            binding.task = task
            binding.root.setOnLongClickListener {

                listener.onItemLongClickListener(task)
                true
            }
            binding.root.setOnClickListener {

                toggle = !toggle

                binding.root.setBackgroundColor(if(toggle) Color.RED else Color.GREEN)
                listener.onItemClickListener(task)
            }
        }

        companion object {
            fun inflateFrom(parent: ViewGroup): TaskVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val rootView = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskVH(rootView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH =
        TaskVH.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        val taskItem = getItem(position)
        holder.bind(taskItem, listener)
    }
}