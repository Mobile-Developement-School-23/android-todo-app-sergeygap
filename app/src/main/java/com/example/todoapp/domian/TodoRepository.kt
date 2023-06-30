package com.example.todoapp.domian

import androidx.lifecycle.LiveData

interface TodoRepository {

    fun addTodoItem(todoItem: TodoItem)
    fun deleteItem(todoItem: TodoItem)


    fun editItem(todoItem: TodoItem)
    fun getTodoItem(todoItemId: Int): TodoItem
    fun getTodoList(): LiveData<List<TodoItem>>

}