package com.example.todoapp.domian

class AddTodoItemUseCase(private val repository: TodoRepository) {
    fun addTodoItem(todoItem: TodoItem) {
        repository.addTodoItem(todoItem)
    }
}