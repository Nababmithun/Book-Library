package com.example.booklibrary.db.entity


import com.google.gson.annotations.SerializedName


data class GsonHelperClass(
    @SerializedName("books") val books: List<Book>
)
