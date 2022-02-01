package com.example.booklibrary.data

import com.example.booklibrary.db.entity.Book
import kotlinx.coroutines.flow.Flow

interface BaseRepository {
    suspend fun getRestaurants(): Flow<List<Book>>
    suspend fun update(restaurant: Book)
    suspend fun getBorrowBook():Flow<List<Book>>
}