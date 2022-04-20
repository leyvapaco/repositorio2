package com.example.miaplicacion.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Defines methods for using the SleepNight class with Room.
 */
@Dao
interface UserDatabaseDao {

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)


    @Query("SELECT * from user_table WHERE userId = :key")
    suspend fun get(key: Long): User?


    @Query("SELECT * FROM user_table ORDER BY userId DESC ")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user_table ORDER BY userId DESC LIMIT 1")
    suspend fun getUser(): User?

    @Query("DELETE FROM user_table")
    suspend fun clear()
}

