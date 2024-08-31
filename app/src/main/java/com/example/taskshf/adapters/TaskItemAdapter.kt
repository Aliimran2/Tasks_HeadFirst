package com.example.taskshf.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskshf.R
import com.example.taskshf.database.Task
import com.example.taskshf.util.TaskDiffUtilItemCallBack

class TaskItemAdapter: ListAdapter<Task, TaskItemAdapter.TaskVH>(TaskDiffUtilItemCallBack()) {

    class TaskVH( val rootView: CardView):RecyclerView.ViewHolder(rootView) {

        val textView : TextView= rootView.findViewById(R.id.task_title)
        val checkBox : CheckBox = rootView.findViewById(R.id.check_box)
        fun bind(task :Task){
            textView.text = task.taskName
            checkBox.isChecked = task.taskDone
        }

        companion object{
            fun inflateFrom(parent: ViewGroup) : TaskVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val rootView = layoutInflater.inflate(R.layout.task_item,parent,false) as CardView
                return TaskVH(rootView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH = TaskVH.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        holder.bind(getItem(position))
    }
}