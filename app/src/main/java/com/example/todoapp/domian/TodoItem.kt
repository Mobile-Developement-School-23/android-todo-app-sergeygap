package com.example.todoapp.domian

import java.util.Date

data class TodoItem(
    var id: Int = UNDEFINED_ID,
    var text: String,
    var importance: Importance,
    var deadline: Date? = null,
    var isDone: Boolean,
    var dateCreation: Date,
    var dateModification: Date? = null,
){
    companion object{
        const val UNDEFINED_ID = -1
    }

}