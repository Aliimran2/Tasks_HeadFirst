package com.example.taskshf.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskshf.R
import com.example.taskshf.database.Task

class TaskItemAdapter: RecyclerView.Adapter<TaskItemAdapter.TaskVH>() {

    var data = listOf<Task>()
        set(value){
            field = value
            notifyDataSetChanged()
        }



    class TaskVH( val rootView: View):RecyclerView.ViewHolder(rootView) {

        val textView = rootView.findViewById<TextView>(R.id.task_title)
        fun bind(task :Task){
            textView.text = task.taskName
        }

        companion object{
            fun inflateFrom(parent: ViewGroup) : TaskVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val rootView = layoutInflater.inflate(R.layout.task_item,parent,false)
                return TaskVH(rootView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH = TaskVH.inflateFrom(parent)

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        holder.bind(data[position])
    }
}