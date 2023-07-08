package com.example.todoapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.domian.TodoItem
import com.example.todoapp.domian.TodoListRepository
import javax.inject.Inject

class TodoListRepositoryImpl @Inject constructor(
    private val todoListDao: TodoListDao,
    private val mapper: TodoListMapper
) : TodoListRepository {
    private val todoItemLiveData = MutableLiveData<List<TodoItem>>()
    override suspend fun addTodoItem(todoItem: TodoItem) {
        todoListDao.addTodoItem(mapper.mapEntityToDbModel(todoItem))
    }

    override suspend fun deleteTodoItem(todoItem: TodoItem) {
        todoListDao.deleteTodoItem(todoItem.id)
    }

    override suspend fun editTodoItem(todoItem: TodoItem) {
        todoListDao.addTodoItem(mapper.mapEntityToDbModel(todoItem))
    }

    override suspend fun getTodoItem(todoItemId: Int): TodoItem {
        val dbModel = todoListDao.getTodoItem(todoItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun addItem(todoItem: TodoItem) {}

    override fun getTodoList(): LiveData<List<TodoItem>> {
        val dbModelLiveData = todoListDao.getTodoList()
        return todoItemLiveData
    }
}
