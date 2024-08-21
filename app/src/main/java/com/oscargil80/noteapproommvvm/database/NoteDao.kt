package com.oscargil80.noteapproommvvm.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oscargil80.noteapproommvvm.model.Note

@Dao// Data access object
interface NoteDao {
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM NOTES ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query ("SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteDesc like  :query")
    fun searchNote(query:String?): LiveData<List<Note>>

}