package com.example.taskshf.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.taskshf.R

class MainActivity : AppCompatActivity() {
    var isToggle = true
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        button= findViewById(R.id.button)
//        val relLayout : RelativeLayout = findViewById(R.id.relativeLayout)
//
//
//        button.setOnClickListener {
//            isToggle = !isToggle
//            button.text = if (isToggle) "Yes" else "No"
//            relLayout.setBackgroundColor(if (isToggle) Color.RED else Color.GREEN)
//        }

    }


}