package com.example.todoapp.di

import android.app.Application
import com.example.todoapp.data.TodoListProvider
import com.example.todoapp.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [DataModule::class, ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(provider: TodoListProvider)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}
