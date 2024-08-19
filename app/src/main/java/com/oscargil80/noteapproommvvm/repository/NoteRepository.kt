package com.oscargil80.noteapproommvvm.repository

import androidx.room.Query
import com.oscargil80.noteapproommvvm.database.NoteDatabase
import com.oscargil80.noteapproommvvm.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun insertNote(note: Note ) = db.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Note ) = db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note ) = db.getNoteDao().deleteNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query:String?) = db.getNoteDao().searchNote(query)




}