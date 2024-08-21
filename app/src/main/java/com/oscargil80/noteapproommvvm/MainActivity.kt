package com.oscargil80.noteapproommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.oscargil80.noteapproommvvm.database.NoteDatabase
import com.oscargil80.noteapproommvvm.repository.NoteRepository
import com.oscargil80.noteapproommvvm.repository.NoteViewModelFactory
import com.oscargil80.noteapproommvvm.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupModel()
    }

    private fun setupModel(){
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
//        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
       noteViewModel = ViewModelProvider(this, viewModelProviderFactory).get(NoteViewModel::class.java)
    }

}