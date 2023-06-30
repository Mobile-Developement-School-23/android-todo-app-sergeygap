package com.example.todoapp.presentation

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.TodoRepositoryImpl
import com.example.todoapp.domian.DeleteTodoItemUseCase
import com.example.todoapp.domian.GetTodoListUseCase
import com.example.todoapp.domian.TodoItem

class MainViewModel : ViewModel() {

    private val repository: TodoRepositoryImpl = TodoRepositoryImpl

    private val getTodoListUseCase = GetTodoListUseCase(repository)
    private val deleteTodoItemUseCase = DeleteTodoItemUseCase(repository)

    val todoList = getTodoListUseCase.getTodoList()

    fun deleteTodoItem(todoItem: TodoItem){
        deleteTodoItemUseCase.deleteTodoItem(todoItem)
    }





}
