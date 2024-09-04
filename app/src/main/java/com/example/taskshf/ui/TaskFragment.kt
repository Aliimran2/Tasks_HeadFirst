package com.example.taskshf.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskshf.adapters.TaskItemAdapter
import com.example.taskshf.database.Task
import com.example.taskshf.database.TaskDatabase
import com.example.taskshf.databinding.FragmentTaskBinding
import com.example.taskshf.listeners.EventListeners
import com.example.taskshf.viewmodel.TaskViewModel
import com.example.taskshf.viewmodel.TaskViewModelFactory


class TaskFragment : Fragment(), EventListeners {

    private var _binding : FragmentTaskBinding?= null
    private val binding get() =  _binding!!
    private lateinit var mViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = TaskDatabase.getInstance(application).taskDao
        val viewModelFactory = TaskViewModelFactory(dao)
        mViewModel = ViewModelProvider(this, viewModelFactory)[TaskViewModel::class.java]




        val taskItemAdapter = TaskItemAdapter(this)
        binding.taskRecyclerView.adapter = taskItemAdapter

        binding.xViewModel = mViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        mViewModel.tasks.observe(viewLifecycleOwner){
            it?.let {
                taskItemAdapter.submitList(it)
            }
        }

        mViewModel.taskToNavigate.observe(viewLifecycleOwner){taskId->
            taskId?.let {
                val action = TaskFragmentDirections.actionTaskFragmentToEditTaskFragment(taskId)
                this.findNavController().navigate(action)
                mViewModel.onTaskNavigated()
            }
        }



        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClickListener(task: Task) {
        mViewModel.onTaskClicked(task.taskId)
    }

    override fun onItemLongClickListener(task: Task): Boolean {
        mViewModel.deleteTask(task)
        Toast.makeText(requireContext(), "${task.taskName} is deleted", Toast.LENGTH_SHORT).show()
        return true
    }
}