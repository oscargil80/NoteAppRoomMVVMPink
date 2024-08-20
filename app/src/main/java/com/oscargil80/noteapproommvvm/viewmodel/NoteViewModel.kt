package com.oscargil80.noteapproommvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.oscargil80.noteapproommvvm.model.Note
import com.oscargil80.noteapproommvvm.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app:Application, private val noteRepository: NoteRepository): AndroidViewModel(app) {

    fun addNote(note:Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }

    fun deleteNOte(note:Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }

    fun updateNOte(note:Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }

    fun  getAllNotes() = noteRepository.getAllNotes()

     fun  searchNotes(query: String?) =  noteRepository.searchNote(query)





}