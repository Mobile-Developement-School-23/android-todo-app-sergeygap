package com.example.todoapp.presentation

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R

class TodoItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val tvText = view.findViewById<TextView>(R.id.preview_text)
    val tvDate = view.findViewById<TextView>(R.id.preview_date)
    val checkBox = view.findViewById<CheckBox>(R.id.preview_checkbox)
}
