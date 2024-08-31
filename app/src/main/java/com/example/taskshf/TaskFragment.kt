package com.example.taskshf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskshf.adapters.TaskItemAdapter
import com.example.taskshf.database.Task
import com.example.taskshf.database.TaskDatabase
import com.example.taskshf.databinding.FragmentTaskBinding
import com.example.taskshf.viewmodel.TaskViewModel
import com.example.taskshf.viewmodel.TaskViewModelFactory


class TaskFragment : Fragment(), OnDeleteTaskListener, OnChangeStateListener {

    private lateinit var mVewModel:TaskViewModel
    private var _binding : FragmentTaskBinding?= null
    private val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = TaskDatabase.getInstance(application).taskDao
        val viewModelFactory = TaskViewModelFactory(dao)
        mVewModel = ViewModelProvider(this, viewModelFactory)[TaskViewModel::class.java]




        val taskItemAdapter = TaskItemAdapter(this, this)
        binding.taskRecyclerView.adapter = taskItemAdapter

        binding.xViewModel = mVewModel
        binding.lifecycleOwner = viewLifecycleOwner

        mVewModel.tasks.observe(viewLifecycleOwner){
            it?.let {
                taskItemAdapter.submitList(it)
            }
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onTaskDelete(task: Task) {
            DialogUtil.showConfirmationDialog(
                requireContext(),
                "Delete Task",
                "Are you sure?",
                {mVewModel.deleteTask(task)},
                { Toast.makeText(requireContext(), "Deletion Cancelled", Toast.LENGTH_SHORT).show()}
            )
    }

    override fun changeState(task: Task) {
        mVewModel.isDoneTask(task)
    }
}