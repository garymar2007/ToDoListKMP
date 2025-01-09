package com.gary.todolistkmp.presentation.screen.task

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.gary.todolistkmp.data.MongoDB
import com.gary.todolistkmp.domain.TaskAction
import com.gary.todolistkmp.domain.ToDoTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class TaskViewModel(private val mongoDB: MongoDB): ScreenModel {

    fun setAction(action: TaskAction) {
        when(action) {
            is TaskAction.Add -> addTask(action.task)
            is TaskAction.Update -> updateTask(action.task)
            is TaskAction.Delete -> deleteTask(action.task)
            is TaskAction.SetCompleted -> setCompleted(action.task, action.completed)
            is TaskAction.SetFavorite -> setFavorite(action.task, action.isFavorite)
        }
    }

    private fun setFavorite(task: ToDoTask, isFavorite: Boolean) {
        screenModelScope.launch(Dispatchers.IO) {
            mongoDB.setFavorite(task, isFavorite)
        }
    }

    private fun setCompleted(task: ToDoTask, completed: Boolean) {
        screenModelScope.launch(Dispatchers.IO) {
            mongoDB.setCompleted(task, completed)
        }
    }

    private fun addTask(task: ToDoTask) {
        screenModelScope.launch(Dispatchers.IO) {
            mongoDB.addTask(task)
        }
    }

    private fun updateTask(task: ToDoTask) {
        screenModelScope.launch(Dispatchers.IO) {
            mongoDB.updateTask(task)
        }
    }

    private fun deleteTask(task: ToDoTask) {
        screenModelScope.launch(Dispatchers.IO) {
            mongoDB.deleteTask(task)
        }
    }
}