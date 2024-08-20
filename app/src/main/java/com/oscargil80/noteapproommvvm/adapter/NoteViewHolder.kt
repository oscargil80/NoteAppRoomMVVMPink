package com.oscargil80.noteapproommvvm.adapter

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.noteapproommvvm.databinding.NoteLayoutBinding
import com.oscargil80.noteapproommvvm.fragments.HomeFragmentDirections
import com.oscargil80.noteapproommvvm.model.Note

class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

private  var binding = NoteLayoutBinding.bind(view)

    fun render(
        Note: Note,
/*        onClickListener: (Note) -> Unit,
        onItemSeleted: (Int) -> Unit,*/
    ) {
       binding.noteTitle.text = Note.noteTitle
        binding.noteDesc.text = Note.noteDesc

        itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(Note)
            it.findNavController().navigate(direction)
        }

        }
    }
