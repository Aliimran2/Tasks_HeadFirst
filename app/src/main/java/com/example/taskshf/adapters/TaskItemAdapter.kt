package com.example.taskshf.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskshf.OnDeleteTaskListener
import com.example.taskshf.R
import com.example.taskshf.database.Task
import com.example.taskshf.databinding.FragmentTaskBinding
import com.example.taskshf.databinding.TaskItemBinding
import com.example.taskshf.util.TaskDiffUtilItemCallBack

class TaskItemAdapter(private val listener: OnDeleteTaskListener): ListAdapter<Task, TaskItemAdapter.TaskVH>(TaskDiffUtilItemCallBack()) {

    class TaskVH(private val binding: TaskItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(task :Task, listener: OnDeleteTaskListener){
            binding.task = task
            binding.root.setOnLongClickListener {
                listener.onTaskDelete(task)
                true
            }
        }

        companion object{
            fun inflateFrom(parent: ViewGroup) : TaskVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val rootView = TaskItemBinding.inflate(layoutInflater,parent,false)
                return TaskVH(rootView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH = TaskVH.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        holder.bind(getItem(position), listener)
    }
}