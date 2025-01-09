package com.gary.todolistkmp.data

import com.gary.todolistkmp.domain.ToDoTask
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class MongoDB {
    private var realm: Realm? = null

    init {
        configuratTheRealm()
    }

    private fun configuratTheRealm() {
        if (realm == null || realm!!.isClosed()) {
            val config = RealmConfiguration.Builder(
                schema = setOf(ToDoTask::class)
            )
                .compactOnLaunch()
                .build()
            realm = Realm.open(config)
        }
    }

    fun readAllTasks(): Flow<RequestState<List<ToDoTask>>>
}