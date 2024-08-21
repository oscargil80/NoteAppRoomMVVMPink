package com.oscargil80.noteapproommvvm.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.oscargil80.noteapproommvvm.MainActivity
import com.oscargil80.noteapproommvvm.R
import com.oscargil80.noteapproommvvm.databinding.FragmentAddNoteBinding
import com.oscargil80.noteapproommvvm.model.Note
import com.oscargil80.noteapproommvvm.viewmodel.NoteViewModel


class AddNoteFragment : Fragment(R.layout.fragment_add_note), MenuProvider {

    private var addNoteBinding: FragmentAddNoteBinding? = null
    private val binding get() = addNoteBinding!!

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var addNoteView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        addNoteBinding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        noteViewModel = (activity as MainActivity).noteViewModel
        addNoteView = view

    }

    private fun saveNote(view: View) {
        val noteTitle = binding.addNoteTitle.text.toString().trim()
        val noteDesc = binding.addNoteDesc.text.toString().trim()

        if (noteTitle.isNotEmpty() && noteDesc.isNotEmpty()) {
            val note = Note(0, noteTitle, noteDesc)
            noteViewModel.addNote(note)
            Toast.makeText(addNoteView.context, "Note Saved", Toast.LENGTH_SHORT).show();
            view.findNavController().popBackStack(R.id.homeFragment, false)
        } else {
            Toast.makeText(addNoteView.context, "Please enter note Tittle", Toast.LENGTH_SHORT)
                .show();
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.menu_add_note,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return  when(menuItem.itemId){
            R.id.saveMenu->{
            saveNote(addNoteView)
            true
        }else ->   false
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        addNoteBinding = null
    }
}