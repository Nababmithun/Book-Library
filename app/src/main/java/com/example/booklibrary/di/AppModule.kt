package com.example.booklibrary.di

import android.content.Context
import androidx.room.Room
import com.example.bookproject.db.BookDatabase
import com.example.booklibrary.data.BaseRepository
import com.example.booklibrary.db.dao.BookDao
import com.example.booklibrary.repository.AppRepository
import com.example.booklibrary.data.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, BookDatabase::class.java, "book_database").build()


    @Singleton
    @Provides
    fun provideDAO(db: BookDatabase) = db.toDoDao()


    @Singleton
    @Provides
    fun provideLocalDataSource(@ApplicationContext context: Context) = LocalDataSource(context)

    @Singleton
    @Provides
    fun provideBaseRepository(
        dao: BookDao,
        localDataSource: LocalDataSource
    ) = AppRepository(dao, localDataSource) as BaseRepository
}