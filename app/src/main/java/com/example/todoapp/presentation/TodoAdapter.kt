package com.example.todoapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.todoapp.R
import com.example.todoapp.domian.TodoItem

class TodoAdapter : ListAdapter<TodoItem, TodoItemViewHolder>(TodoItemDiffCallback()) {

    var onTodoItemClickListener: ((TodoItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return TodoItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val todoItem = getItem(position)
        holder.view.setOnClickListener {
            onTodoItemClickListener?.invoke(todoItem)
        }
        holder.tvText.text = todoItem.text
        holder.tvDate.text = todoItem.deadline.toString()
        holder.checkBox.isChecked = todoItem.isDone //
    }
}
