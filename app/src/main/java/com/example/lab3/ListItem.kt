package com.example.lab3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListItem: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_item)
        findViewById<TextView>(R.id.title_text_view).text = intent.getStringExtra("title")
        findViewById<TextView>(R.id.description_text_view).text = intent.getStringExtra("desc")
        findViewById<ImageView>(R.id.priority_image_view).setImageResource(R.drawable.ic_priority_high)
    }

}