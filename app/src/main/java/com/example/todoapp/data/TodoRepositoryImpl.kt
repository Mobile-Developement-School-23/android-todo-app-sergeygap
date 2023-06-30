package com.example.todoapp.data

import androidx.lifecycle.LiveData
import com.example.todoapp.domian.TodoItem
import com.example.todoapp.domian.TodoRepository

class TodoRepositoryImpl: TodoRepository {

    private val todoList = sortedSetOf<TodoItem>({o1, o2 -> o1.id.compareTo(o2.id)})
    private var autoIncrementId = 0

    override fun addTodoItem(todoItem: TodoItem) {
        if (todoItem.id == TodoItem.UNDEFINED_ID){
            todoItem.id = autoIncrementId++
        }


    }

    override fun deleteItem(todoItem: TodoItem) {
        TODO("Not yet implemented")
    }



    override fun getTodoItem(todoItemId: Int): TodoItem {
        TODO("Not yet implemented")
    }

    override fun getTodoList(): LiveData<List<TodoItem>> {
        TODO("Not yet implemented")
    }


    override fun editItem(todoItem: TodoItem) {}

}