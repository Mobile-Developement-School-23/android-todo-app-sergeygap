package com.example.todoapp.domian

import javax.inject.Inject

class DeleteTodoItemUseCase @Inject constructor(private val repository: TodoListRepository) {
    suspend fun deleteTodoItem(todoItem: TodoItem) {
        repository.deleteTodoItem(todoItem)
    }
}
