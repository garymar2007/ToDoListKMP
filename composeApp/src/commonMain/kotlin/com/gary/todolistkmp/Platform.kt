package com.gary.todolistkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform