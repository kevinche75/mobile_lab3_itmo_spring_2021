package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_activity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.add_item_menu, menu)
        return true
    }

    private fun saveItem(){
        val editTextTitile = findViewById<EditText>(R.id.edit_title)
        val editTextDesc = findViewById<EditText>(R.id.edit_desc)
        val checkImp = findViewById<CheckBox>(R.id.check_imp)

        val title = editTextTitile.text.toString().trim()
        val desc = editTextDesc.text.toString().trim()
        val check = checkImp.isChecked

        if (title.isNotEmpty() && desc.isNotEmpty()){
            val intent = Intent()
            intent.putExtra("title", title)
            intent.putExtra("desc", desc)
            intent.putExtra("check", check)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_item -> {
                saveItem()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}