package com.example.bookproject.db

import androidx.room.*
import com.example.booklibrary.db.dao.BookDao
import com.example.booklibrary.db.entity.Book


@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {

    abstract fun toDoDao(): BookDao

}