package com.example.todoapp.domian

class GetTodoItemUseCase(private val repository: TodoRepository) {
    fun getTodoItem(todoItemId: Int): TodoItem {
        return repository.getTodoItem(todoItemId)
    }
}