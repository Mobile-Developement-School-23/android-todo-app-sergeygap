package com.example.todoapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R

class MainMenuFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var todoAdapter: TodoAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupRecyclerView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.todoList.observe(viewLifecycleOwner) {
            todoAdapter.submitList(it)//подписка
        }
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.todo_rv_list)
    }

    private fun setupRecyclerView() {
        todoAdapter = TodoAdapter()
        recyclerView.adapter = todoAdapter
        setupClickListener()
        setupSwipeListener(recyclerView)

    }

    private fun setupSwipeListener(recyclerView: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = todoAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteTodoItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun setupClickListener() {
        todoAdapter.onTodoItemClickListener = {
            startSettingFragment()
        }
    }

    private fun startSettingFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SettingsFragment())
            .addToBackStack(null)
            .commit()
    }

}