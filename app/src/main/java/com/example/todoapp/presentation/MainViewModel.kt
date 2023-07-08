package com.example.todoapp.presentation

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.RepositoryImpl
import com.example.todoapp.domian.DeleteTodoItemUseCase
import com.example.todoapp.domian.GetTodoListUseCase
import com.example.todoapp.domian.TodoItem

class MainViewModel : ViewModel() {

    private val repository: RepositoryImpl = RepositoryImpl

    private val getTodoListUseCase = GetTodoListUseCase(repository)
    private val deleteTodoItemUseCase = DeleteTodoItemUseCase(repository)

    val todoList = getTodoListUseCase.getTodoList()

    suspend fun deleteTodoItem(todoItem: TodoItem) {
        deleteTodoItemUseCase.deleteTodoItem(todoItem)
    }
}
