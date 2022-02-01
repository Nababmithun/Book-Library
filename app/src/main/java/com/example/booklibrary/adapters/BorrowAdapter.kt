package com.example.booklibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.booklibrary.databinding.ReturnItemLayoutBinding
import com.example.booklibrary.db.entity.Book

class BorrowAdapter (private val cellClickListener: CellClickListener1): RecyclerView.Adapter<BorrowAdapter.BorrowViewHolder>() {

    inner class BorrowViewHolder(val binding: ReturnItemLayoutBinding):
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

    var tvShows1: List<Book>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BorrowViewHolder {
        return BorrowViewHolder(
            ReturnItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BorrowViewHolder, position: Int) {
        val currentTvShow = tvShows1[position]

        holder.binding.apply {
            bookName.text=currentTvShow.BOOK_NAME
            val test = currentTvShow.BOOK_NAME
            val s = test.substring(0, 1)
            appCompatFocusTextView.text=s
        }
        holder.binding.returnButton.setOnClickListener {
            cellClickListener.onCellClickListener1(currentTvShow)
        }

    }

    override fun getItemCount() = tvShows1.size

    interface CellClickListener1 {
        fun onCellClickListener1(data: Book)


    }

}