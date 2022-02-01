package com.example.booklibrary.ui.login.book

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booklibrary.data.BaseRepository
import com.example.booklibrary.db.entity.Book

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel
@Inject constructor(private val repository: BaseRepository) : ViewModel() {


    internal fun update(book: Book) = viewModelScope.launch {
        repository.update(book)
    }

    private val allBorrowItems = MediatorLiveData<List<Book>>()
    internal fun getBorrowBook(): MediatorLiveData<List<Book>> {
        viewModelScope.launch {
            repository.getBorrowBook().collect{ items->
                Log.d("data borrow",items.toString())
                allBorrowItems.value = items
            }
        }
        return allBorrowItems
    }

    private val allItems = MediatorLiveData<List<Book>>()


    internal fun getRestaurants(): LiveData<List<Book>> {
        viewModelScope.launch {
            repository.getRestaurants().collect { items ->
                Log.d("data",items.toString())
                allItems.value = items
            }
        }
        return allItems
    }



}