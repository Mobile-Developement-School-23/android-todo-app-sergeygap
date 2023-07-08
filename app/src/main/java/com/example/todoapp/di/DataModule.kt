package com.example.todoapp.di

import android.app.Application
import com.example.todoapp.data.AppDatabase
import com.example.todoapp.data.TodoListDao
import com.example.todoapp.data.TodoListRepositoryImpl
import com.example.todoapp.domian.TodoListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindTodoListRepository(impl: TodoListRepositoryImpl): TodoListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideTodoListDao(
            application: Application
        ): TodoListDao {
            return AppDatabase.getInstance(application).todoListDao()
        }
    }
}
