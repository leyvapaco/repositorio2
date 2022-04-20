package com.example.miaplicacion.first

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.miaplicacion.database.UserDatabaseDao
import com.example.miaplicacion.database.User
import kotlinx.coroutines.*


class FirstViewModel(
    val database: UserDatabaseDao,
    application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    private var thisuser = MutableLiveData<User?>()


    private val users = database.getAllUsers()

    init {
        initializeUser()
        onInsert()
    }


    private suspend fun clear() {
        database.clear()
    }

    private suspend fun update(user: User) {
        database.update(user)
    }

    private suspend fun insert(user: User) {
        database.insert(user)
    }

    private fun initializeUser() {
        viewModelScope.launch {
            thisuser.value = getUserFromDatabase()
        }
    }

    private suspend fun getUserFromDatabase(): User? {
        var miUser = database.getUser()
        return miUser
    }

    fun onInsert() {
        viewModelScope.launch {
            // Create a new night, which captures the current time,
            // and insert it into the database.
            val newUser = User()
            newUser.userDorsal=8
            insert(newUser)
            thisuser.value = getUserFromDatabase()

        }
    }


    fun onClear() {
        viewModelScope.launch {
            // Clear the database table.
            clear()

            // And clear tonight since it's no longer in the database
            thisuser.value = null
        }
    }
}

