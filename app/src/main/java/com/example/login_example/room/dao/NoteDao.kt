package com.example.login_example.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.login_example.data.Note

interface NoteDao {

    @Query("SELECT * FROM Note")
    suspend fun getNote(note: Note)

    @Insert
    suspend fun addNote(note: Note)

    @Delete
    suspend fun delateNote(note: Note)
}