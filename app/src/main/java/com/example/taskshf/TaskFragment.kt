package com.example.taskshf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.taskshf.database.TaskDatabase
import com.example.taskshf.databinding.FragmentTaskBinding
import com.example.taskshf.viewmodel.TaskViewModel
import com.example.taskshf.viewmodel.TaskViewModelFactory
import java.util.zip.Inflater


class TaskFragment : Fragment() {

    private var _binding : FragmentTaskBinding?= null
    private val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_task,container,false)
        _binding = FragmentTaskBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = TaskDatabase.getInstance(application).taskDao
        val viewModelFactory = TaskViewModelFactory(dao)
        val mVewModel = ViewModelProvider(this, viewModelFactory)[TaskViewModel::class.java]


        binding.xViewModel = mVewModel


        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}