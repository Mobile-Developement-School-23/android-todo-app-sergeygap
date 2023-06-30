package com.example.todoapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.domian.Importance
import com.example.todoapp.domian.TodoItem
import com.example.todoapp.domian.TodoRepository
import java.text.SimpleDateFormat
import kotlin.random.Random

object TodoRepositoryImpl : TodoRepository {

    private val todoItemLiveData = MutableLiveData<List<TodoItem>>()
    private val todoList =
        sortedSetOf<TodoItem>({ o1, o2 -> o1.id.compareTo(o2.id) })// в порядке возрастания id
    private var autoIncrementId = 0
    private val todoTextList = listOf<String>(
        "Купить продукты",
        "Помыть машину",
        "Погулять с собакой",
        "Зайти в спортивный магазин",
        "Снять деньги",
        "Убраться",
        "Сделать задания",
        "Сходить в зал",
        "Потренироваться",
        "Купить абонемент"
    )

    init {
        val importanceValue = Importance.values()
        for (i in 0 until 10) {
            val randomImportance = importanceValue.random()
            val item = TodoItem(
                id = i,
                text = todoTextList[i],
                importance = randomImportance,
                null,
                Random.nextBoolean(),
                "",
                //SimpleDateFormat("dd.MM.yyyy").parse("10 .10.2010"),
                null
            )
            addTodoItem(item)
        }
    }

    override fun addTodoItem(todoItem: TodoItem) {
        if (todoItem.id == TodoItem.UNDEFINED_ID) {
            todoItem.id = autoIncrementId++
        }
        todoList.add(todoItem)
        updateListLD()

    }

    override fun deleteItem(todoItem: TodoItem) {
        todoList.remove(todoItem)
        updateListLD()
    }


    override fun getTodoItem(todoItemId: Int): TodoItem {
        return todoList.find {
            it.id == todoItemId
        } ?: throw RuntimeException("TodoItem with $todoItemId not found")
    }

    override fun getTodoList(): LiveData<List<TodoItem>> {
        return todoItemLiveData
    }

    private fun updateListLD() {
        todoItemLiveData.value = todoList.toList()
    }

    override fun editItem(todoItem: TodoItem) {}

}