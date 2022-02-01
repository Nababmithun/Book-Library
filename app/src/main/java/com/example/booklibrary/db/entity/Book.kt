package com.example.booklibrary.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Book(
    @PrimaryKey(autoGenerate = false) val BOOKID: Int,
    @SerializedName("BOOK_NAME") val BOOK_NAME: String,
    @SerializedName("BOOK_QTY") var BOOK_QTY: Int,
    var BORROWED: Boolean = false
)