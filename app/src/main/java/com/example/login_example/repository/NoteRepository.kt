package com.example.login_example.repository

import com.example.login_example.data.Note

interface NoteRepository {
    suspend fun deleteNote(note: Note)
    suspend fun addNote(note: Note)

}