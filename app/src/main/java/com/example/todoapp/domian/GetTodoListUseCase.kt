package com.example.todoapp.domian

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetTodoListUseCase @Inject constructor(private val repository: TodoListRepository) {
    fun getTodoList(): LiveData<List<TodoItem>> {
        return repository.getTodoList()
    }
}
