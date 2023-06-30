package com.example.todoapp.domian

class GetTodoItemUseCase(private val repository: TodoRepository) {
    fun getTodoItem(todoItemId: Int){
        repository.getTodoItem(todoItemId)
    }
}