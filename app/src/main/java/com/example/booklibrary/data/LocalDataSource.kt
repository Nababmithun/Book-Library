package com.example.booklibrary.data

import android.content.Context
import com.example.booklibrary.db.entity.Book

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class LocalDataSource(private val context: Context) {

    fun getRestaurants(): List<Book> {
        val content = getFileContent()
        return Gson().fromJson(content, object : TypeToken<List<Book>>(){}.type)
    }

    private fun getFileContent(): String = context.assets
        .open("filmes.json")
        .bufferedReader()
        .use { it.readText() }
}