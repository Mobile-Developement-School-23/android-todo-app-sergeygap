package com.example.todoapp.domian

import java.util.Date

data class TodoItem(
    var id: Int = UNDEFINED_ID,
    var text: String,
    var importance: Importance? = Importance.MID,
    var deadline: Date? = null,
    var isDone: Boolean,
    var dateCreation: Date? = null,
    var dateModification: Date? = null,
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
