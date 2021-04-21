package com.example.lab3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val listItem = ArrayList<Item>()
    private val ADD_ITEM_REQUEST = 1
    private val adapter = AndroidAdapter(listItem)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddItem: FloatingActionButton = findViewById(R.id.button_add_item)
        buttonAddItem.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivityForResult(intent, ADD_ITEM_REQUEST)
        }

        val list = findViewById<RecyclerView>(R.id.recycle_view)
        list.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val title = data?.getStringExtra("title")
        val desc = data?.getStringExtra("desc")
        val check = data?.getBooleanExtra("check", false)

        val newItem = Item(title, desc, check)
        listItem.add(listItem.size, newItem)
        adapter.notifyItemInserted(listItem.size-1)
    }
}