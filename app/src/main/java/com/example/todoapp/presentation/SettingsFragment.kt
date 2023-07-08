package com.example.todoapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.example.todoapp.R
import com.example.todoapp.domian.Importance
import com.example.todoapp.domian.TodoItem
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat

class SettingsFragment : Fragment() {

    private var screenMode: String = MODE_UNKNOWN
    private var todoItemId: Int = TodoItem.UNDEFINED_ID
    private lateinit var viewModel: SettingsViewModel
    private lateinit var mainViewModel: MainViewModel

    private lateinit var exitButton: ImageButton
    private lateinit var saveButton: Button
    private lateinit var deleteButton: MaterialButton
    private lateinit var editText: EditText

    private lateinit var importance: RadioGroup
    private lateinit var highButton: RadioButton // todo
    private lateinit var midButton: RadioButton
    private lateinit var lowButton: RadioButton

    private lateinit var dateSwitch: SwitchCompat
    private lateinit var dateSelect: LinearLayout // todo
    private lateinit var dateView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        launchRightMode()
    }

    private fun launchRightMode() {
        when (screenMode) {
            MODE_EDIT -> launchEditMode()
            MODE_ADD -> launchAddMode()
        }
    }

    private fun launchEditMode() {
//        deleteButton.setOnClickListener {
//            val item = viewModel.getTodoItem(todoItemId)
// //            mainViewModel.deleteTodoItem()
//        }
    }

    private fun launchAddMode() {
        saveButton.setOnClickListener {
            viewModel.addTodoItem(
                editText.text.toString(),
                searchImportance(),
                false,
                SimpleDateFormat("dd.MM.yyyy").parse("09.10.2003")
            )
        }
    }

    private fun searchImportance(): Importance {
        val selectedRadioButtonId = importance.checkedRadioButtonId
        val selectedRadioButton = view?.findViewById<RadioButton>(selectedRadioButtonId)
        return when (selectedRadioButton?.text.toString()) {
            getString(R.string.high_importance) -> Importance.HIGH
            getString(R.string.mid_importance) -> Importance.MID
            getString(R.string.high_importance) -> Importance.HIGH
            else -> Importance.MID
        }
    }

    private fun initViews(view: View) {
        exitButton = view.findViewById(R.id.editor_exit)
        saveButton = view.findViewById(R.id.editor_save)
        deleteButton = view.findViewById(R.id.editor_delete)
        editText = view.findViewById(R.id.editor_text)

        importance = view.findViewById(R.id.editor_importance)
        highButton = view.findViewById(R.id.editor_high)
        midButton = view.findViewById(R.id.editor_mid)
        lowButton = view.findViewById(R.id.editor_low)

        dateSwitch = view.findViewById(R.id.editor_has_date)
        dateSelect = view.findViewById(R.id.editor_date)
        dateView = view.findViewById(R.id.editor_date_view)
    }

    private fun parseParams() {
        val args = requireArguments()
        if (!args.containsKey(SCREEN_MODE)) {
            throw RuntimeException("Param screen mode is absent")
        }
        val mode = args.getString(SCREEN_MODE)
        if (mode != MODE_EDIT && mode != MODE_ADD) {
            throw RuntimeException("Unknown screen mode $mode")
        }
        screenMode = mode
        if (screenMode == MODE_EDIT) {
            if (!args.containsKey(TODO_ITEM_ID)) {
                throw RuntimeException("Param todo item id is absent")
            }
            todoItemId = args.getInt(TODO_ITEM_ID, TodoItem.UNDEFINED_ID)
        }
    }

    fun newInstanceAddItem(): SettingsFragment {
        return SettingsFragment().apply {
            arguments = Bundle().apply {
                putString(SCREEN_MODE, MODE_ADD)
            }
        }
    }

    fun newInstanceEditItem(todoItemId: Int): SettingsFragment {
        return SettingsFragment().apply {
            arguments = Bundle().apply {
                putString(SCREEN_MODE, MODE_EDIT)
                putInt(TODO_ITEM_ID, todoItemId)
            }
        }
    }

    companion object {
        const val SCREEN_MODE = "extra_mode"
        const val MODE_ADD = "mode_add"
        const val MODE_EDIT = "mode_edit"
        private const val MODE_UNKNOWN = ""
        private const val TODO_ITEM_ID = "extra_todo_item_id"
    }
}
