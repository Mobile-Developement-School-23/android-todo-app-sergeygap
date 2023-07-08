package com.example.todoapp.domian

class AddItem(private val repository: TodoListRepository) {
     fun addItem(todoItem: TodoItem) {
        repository.addItem(todoItem)
    }
}
