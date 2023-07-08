package com.example.todoapp.data

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoListDao {

    @Query("SELECT * FROM todo_items")
    fun getTodoList(): LiveData<List<TodoItemDbModel>>

    @Query("SELECT * FROM todo_items")
    fun getTodoListCursor(): Cursor

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodoItem(todoItemDbModel: TodoItemDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTodoItemSync(todoItemDbModel: TodoItemDbModel)

    @Query("DELETE FROM todo_items WHERE id=:todoItemId")
    suspend fun deleteTodoItem(todoItemId: Int)

    @Query("DELETE FROM todo_items WHERE id=:todoItemId")
    fun deleteTodoItemSycn(todoItemId: Int): Int

    @Query("SELECT * FROM todo_items WHERE id=:todoItemId LIMIT 1")
    suspend fun getTodoItem(todoItemId: Int): TodoItemDbModel
}
