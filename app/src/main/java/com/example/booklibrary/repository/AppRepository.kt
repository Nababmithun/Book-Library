package com.example.booklibrary.repository

import androidx.lifecycle.asFlow
import com.example.booklibrary.data.BaseRepository
import com.example.booklibrary.data.LocalDataSource
import com.example.booklibrary.db.dao.BookDao
import com.example.booklibrary.db.entity.Book

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AppRepository @Inject constructor(
    private val dao: BookDao,
    private val localSource: LocalDataSource
) : BaseRepository {

    override suspend fun getRestaurants(): Flow<List<Book>> {
        return withContext(Dispatchers.IO) {
            val count = dao.getCount()
            if (count == 0) {
                dao.insert(localSource.getRestaurants())
            }
            dao.getAllBook().asFlow()

        }
    }


    override suspend fun update(book: Book) = dao.update(book)
    override suspend fun getBorrowBook(): Flow<List<Book>> {
        return dao.getBorrowBook().asFlow()
    }

    // =dao.getBorrowBook(status)
  //  override suspend fun getBorrowBook(status: String): Flow<List<Book>> = dao.getBorrowBook().asFlow()
//    return withContext(Dispatchers.IO) {
//        val count = dao.getCount()
//        if (count == 0) {
//            dao.insert(localSource.getRestaurants())
//        }
//        dao.getAllBook().asFlow()
//
//    }
//
//    }
}