package com.gary.todolistkmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ToDoListKMP",
    ) {
        App()
    }
}