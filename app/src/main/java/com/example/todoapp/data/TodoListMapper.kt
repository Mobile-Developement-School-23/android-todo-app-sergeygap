package com.example.todoapp.data

import com.example.todoapp.domian.TodoItem
import javax.inject.Inject

class TodoListMapper @Inject constructor() {

    fun mapEntityToDbModel(todoItem: TodoItem) = TodoItemDbModel(
        id = todoItem.id,
        name = todoItem.text,
        isDone = todoItem.isDone
    )

    fun mapDbModelToEntity(todoItemDbModel: TodoItemDbModel) = TodoItem(
        id = todoItemDbModel.id,
        text = todoItemDbModel.name,
        isDone = todoItemDbModel.isDone,
    )

    fun mapListDbModelToListEntity(list: List<TodoItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}
