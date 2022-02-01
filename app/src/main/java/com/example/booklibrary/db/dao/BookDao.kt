package com.example.booklibrary.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.booklibrary.db.entity.Book


@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<Book>)

    @Update
    suspend fun update(book: Book)

    @Query("SELECT * FROM Book")
    fun getAllBook(): LiveData<List<Book>>

    @Query("SELECT * FROM Book WHERE BORROWED = 1")
    fun getBorrowBook(): LiveData<List<Book>>

    @Query("SELECT Count(*) FROM Book")
    fun getCount(): Int
}