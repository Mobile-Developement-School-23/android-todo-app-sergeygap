package com.example.todoapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.R
import com.example.todoapp.data.TodoRepositoryImpl
import com.example.todoapp.domian.AddTodoItemUseCase
import com.example.todoapp.domian.GetTodoItemUseCase
import com.example.todoapp.domian.Importance
import com.example.todoapp.domian.TodoItem
import java.util.Date

class SettingsViewModel : ViewModel() {


    private lateinit var repository: TodoRepositoryImpl

    private val addTodoItemUseCase = AddTodoItemUseCase(repository)
    private val getTodoItemUseCase = GetTodoItemUseCase(repository)

    private val _todoItem = MutableLiveData<TodoItem>()
    val shopItem: LiveData<TodoItem>
        get() = _todoItem

    fun getTodoItem(todoItemId: Int) {
        val item = getTodoItemUseCase.getTodoItem(todoItemId)
        _todoItem.value = item
    }

    fun addTodoItem(
        inputText: String?,
        importance: Importance,
        isDone: Boolean,
        dateCreation: Date
    ) {
        var newInputText = inputText
        if (newInputText.isNullOrBlank()) {
            newInputText = "Без названия"
        }
//        val todoItem = TodoItem()
    }

}
