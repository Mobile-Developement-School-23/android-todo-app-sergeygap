package com.example.todoapp.domian

import javax.inject.Inject

class AddTodoItemUseCase @Inject constructor(private val repository: TodoListRepository) {
    suspend fun addTodoItem(todoItem: TodoItem) {
        repository.addTodoItem(todoItem)
    }
}
