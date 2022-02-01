package com.example.booklibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.booklibrary.R


import com.example.booklibrary.databinding.ListitembookBinding
import com.example.booklibrary.db.entity.Book


class BookAdapter(private val cellClickListener: CellClickListener): RecyclerView.Adapter<BookAdapter.FilmeViewHolder>() {

    inner class FilmeViewHolder(val binding: ListitembookBinding):
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Book>(){
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.BOOKID == newItem.BOOKID
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return newItem == oldItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)

    var tvShows: List<Book>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        return FilmeViewHolder(
            ListitembookBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.binding.apply {
            bookName.text=currentTvShow.BOOK_NAME
            val test = currentTvShow.BOOK_NAME
            val s = test.substring(0, 1)
            focus.text = s
            bookCount.text =currentTvShow.BOOK_QTY.toString()
            if(currentTvShow.BORROWED==false){
                borrowButton.setBackgroundResource(R.drawable.redbackround)
                borrowButton.text="Borrow"
            }else{
                borrowButton.setBackgroundResource(R.drawable.ll)
                borrowButton.text="Limited Quantity"
                borrowButton.isEnabled = false
                borrowButton.isClickable = false

            }
        }
        holder.binding.borrowButton.setOnClickListener {
            cellClickListener.onCellClickListener(currentTvShow)
        }

    }


    override fun getItemCount() = tvShows.size
    interface CellClickListener {
        fun onCellClickListener(data: Book)

    }
}