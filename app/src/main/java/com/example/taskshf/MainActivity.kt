package com.example.taskshf

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

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