package com.example.todoapp.domian

class DeleteTodoItemUseCase(private val repository: TodoRepository) {
    fun deleteTodoItem(todoItem: TodoItem){
        repository.deleteItem(todoItem)
    }
}