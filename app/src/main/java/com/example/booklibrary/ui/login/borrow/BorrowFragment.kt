package com.example.booklibrary.ui.login.borrow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booklibrary.R
import com.example.booklibrary.adapters.BorrowAdapter
import com.example.booklibrary.databinding.FragmentBorrowBinding
import com.example.booklibrary.db.entity.Book
import com.example.booklibrary.ui.login.book.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BorrowFragment : Fragment(), BorrowAdapter.CellClickListener1 {
    private var _binding: FragmentBorrowBinding?=null
    private val binding get()= _binding!!

    private val viewModel1: AppViewModel by viewModels()
    private lateinit var bookAdapter: BorrowAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBorrowBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookAdapter= BorrowAdapter(this)
            binding.borrowRv.apply {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = bookAdapter
            }




        viewModel1.getBorrowBook().observe(requireActivity()) { listTvShows1 ->
            Log.d("data borrow", listTvShows1.toString())
            Toast.makeText(requireContext(),listTvShows1.toString(),Toast.LENGTH_LONG).show()
            bookAdapter.tvShows1=listTvShows1



        }
    }

    override fun onCellClickListener1(data: Book) {
        val q = data.BOOK_QTY+1
        GlobalScope.launch {
            viewModel1.update(Book(data.BOOKID,data.BOOK_NAME,q,false))
            delay(500)
        }

        findNavController().navigate(R.id.action_borrowFragment_to_booksFragment)
    }

}