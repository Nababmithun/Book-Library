package com.example.booklibrary.data

import android.content.Context
import com.example.booklibrary.db.entity.Book

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class LocalDataSource(private val context: Context) {

    fun getRestaurants(): List<Book> {
        val content = getFileContent()
//        val helperClass: GsonHelperClass =
//            Gson().fromJson(content, object : TypeToken<List<Book>>(){}.type)
        return Gson().fromJson(content, object : TypeToken<List<Book>>(){}.type)
    }
    //getListFilmesGson(): ArrayList<Filme> {

//String val1 = "[{test: \"test\"}]";
//
//final GsonBuilder gsonBuilder = new GsonBuilder();
//final Gson gson = gsonBuilder.create();
//
//TestCase[] testCase = gson.fromJson(val1, TestCase[].class);
    //Gson().fromJson(jsonString, object : TypeToken<ArrayList<Filme>>(){}.type)
    private fun getFileContent(): String = context.assets
        .open("filmes.json")
        .bufferedReader()
        .use { it.readText() }
}