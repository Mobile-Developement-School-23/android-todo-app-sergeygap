package com.example.todoapp.data

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.todoapp.domian.TodoItem
import javax.inject.Inject

class TodoListProvider : ContentProvider() {

    @Inject
    lateinit var todoListDao: TodoListDao

    @Inject
    lateinit var mapper: TodoListMapper

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI("com.example.todoapp", "todo_items", GET_TODO_ITEMS_QUERY)
        addURI("com.example.todoapp", "todo_items/#", GET_TODO_ITEM_BY_ID_QUERY)
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            GET_TODO_ITEMS_QUERY -> {
                todoListDao.getTodoListCursor()
            }
            else -> {
                null
            }
        }
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        when (uriMatcher.match(uri)) {
            GET_TODO_ITEMS_QUERY -> {
                if (values == null) return null
                val id = values.getAsInteger("id")
                val name = values.getAsString("name")
                val count = values.getAsInteger("count")
                val enabled = values.getAsBoolean("enabled")
                val todoItem = TodoItem(
                    id = id,
                    text = name,
                    isDone = enabled
                )
                todoListDao.addTodoItemSync(mapper.mapEntityToDbModel(todoItem))
            }
        }
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        when (uriMatcher.match(uri)) {
            GET_TODO_ITEMS_QUERY -> {
                val id = selectionArgs?.get(0)?.toInt() ?: -1
                return todoListDao.deleteTodoItemSycn(id)
            }
        }
        return 0
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

    companion object {

        private const val GET_TODO_ITEMS_QUERY = 100
        private const val GET_TODO_ITEM_BY_ID_QUERY = 101
    }
}
