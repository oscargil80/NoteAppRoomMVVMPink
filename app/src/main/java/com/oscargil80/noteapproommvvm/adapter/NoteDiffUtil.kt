package com.oscargil80.noteapproommvvm.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.oscargil80.noteapproommvvm.model.Note

class NoteDiffUtill(

) : DiffUtil.ItemCallback<Note>() {


    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.noteDesc == newItem.noteDesc &&
                oldItem.noteTitle == newItem.noteTitle
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return  oldItem == newItem
    }

  //  val differ= AsyncListDiffer(NoteAdapter, )
}

/* override fun getOldListSize(): Int = oldList.size

override fun getNewListSize(): Int = newList.size

override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return oldList[oldItemPosition].id == newList[newItemPosition].id
}

override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return oldList[oldItemPosition] == newList[newItemPosition]
}*/