package com.example.lab3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AndroidAdapter(private val android: List<Item>): RecyclerView.Adapter<AndroidAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = android.size

    private fun getItem(position: Int) : Item = android[position]

    class ViewHolder(itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private val image: ImageView = itemView.findViewById(R.id.priority_image_view)
        private val title: TextView = itemView.findViewById(R.id.title_text_view)
        private val desc: TextView = itemView.findViewById(R.id.description_text_view)

        fun bind(item: Item){
            image.visibility = if (item.imp!!) View.VISIBLE else View.GONE
            title.text = item.title
            desc.text = item.desc
        }
    }
}