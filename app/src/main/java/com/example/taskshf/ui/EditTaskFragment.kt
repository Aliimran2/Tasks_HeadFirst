package com.example.taskshf.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.taskshf.R

class EditTaskFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_task, container, false)

        val btn:Button = view.findViewById(R.id.updateTask)
        val taskId = EditTaskFragmentArgs.fromBundle(requireArguments()).taskId
        btn.text = taskId.toString()

        return view
    }


}