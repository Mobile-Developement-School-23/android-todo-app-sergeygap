package com.example.todoapp.domian

import androidx.lifecycle.LiveData

interface TodoListRepository {
    suspend fun addTodoItem(todoItem: TodoItem)
    suspend fun deleteTodoItem(todoItem: TodoItem)
    suspend fun editTodoItem(todoItem: TodoItem)
    suspend fun getTodoItem(todoItemId: Int): TodoItem
    fun addItem(todoItem: TodoItem)
    fun getTodoList(): LiveData<List<TodoItem>>
}
