package com.example.todoapp.domian

import javax.inject.Inject

class GetTodoItemUseCase @Inject constructor(private val repository: TodoListRepository) {
    suspend fun getTodoItem(todoItemId: Int): TodoItem {
        return repository.getTodoItem(todoItemId)
    }
}
