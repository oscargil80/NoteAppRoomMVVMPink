package com.oscargil80.noteapproommvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.noteapproommvvm.R
import com.oscargil80.noteapproommvvm.model.Note


class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(layoutInflater.inflate(R.layout.note_layout, parent, false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.render(item)//, onClickListener, onItemSeleted)
    }

    override fun getItemCount(): Int = differ.currentList.size



    private val differCallback = object : DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return  oldItem.id == newItem.id &&
                    oldItem.noteDesc == newItem.noteDesc &&
                    oldItem.noteTitle == newItem.noteTitle
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return  oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)
}



/* fun UpdateList(newList: List<Note>){
    val PaieseAmericaDiff = PaisesAmericaDiffUtill(PaisesAmericaList, newList)
    val result = DiffUtil.calculateDiff(PaieseAmericaDiff)
    PaisesAmericaList = newList
    result.dispatchUpdatesTo(this)
}*/
