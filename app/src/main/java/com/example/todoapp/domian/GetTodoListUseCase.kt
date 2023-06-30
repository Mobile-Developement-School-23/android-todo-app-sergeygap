package com.example.todoapp.domian

import androidx.lifecycle.LiveData

class GetTodoListUseCase(private val repository: TodoRepository) {
    fun getTodoList(): LiveData<List<TodoItem>>{
        return repository.getTodoList()
    }
}