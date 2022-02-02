package com.example.booklibrary.ui.login.book

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.booklibrary.R
import com.example.booklibrary.adapters.BookAdapter
import com.example.booklibrary.databinding.FragmentBooksBinding


import com.example.booklibrary.db.entity.Book

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BooksFragment : Fragment(), BookAdapter.CellClickListener {
    private var _binding: FragmentBooksBinding?=null
    private val binding get()= _binding!!

    private val viewModel1: AppViewModel by viewModels()
    private lateinit var bookAdapter: BookAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBooksBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookAdapter= BookAdapter(this)
        binding.rvFilmes.apply {

            layoutManager = GridLayoutManager(requireContext(),2)
            setHasFixedSize(true)
            adapter = bookAdapter
        }
        viewModel1.getRestaurants().observe(requireActivity()) { listTvShows ->

            Log.d("data", listTvShows.toString())
            bookAdapter.tvShows=listTvShows

        }

    }


    override fun onCellClickListener(data: Book) {
            val q = data.BOOK_QTY-1

        GlobalScope.launch {
            viewModel1.update(Book(data.BOOKID,data.BOOK_NAME,q,true))
                delay(400)

        }

            findNavController().navigate(R.id.action_booksFragment_to_borrowFragment)

    }

}