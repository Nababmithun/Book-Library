package com.example.bookproject.db

import androidx.room.*
import com.example.booklibrary.db.dao.BookDao
import com.example.booklibrary.db.entity.Book


@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {

    abstract fun toDoDao(): BookDao



//    companion object {
//        @Volatile
//        private var INSTANCE: BookDatabase? = null
//
//        fun getDatabase(context: Context): BookDatabase =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE
//                    ?: buildDatabase(context).also { INSTANCE = it }
//            }
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                BookDatabase::class.java, "book_database"
//            ).build()
//    }

}