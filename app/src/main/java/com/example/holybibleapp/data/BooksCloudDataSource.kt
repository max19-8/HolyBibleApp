package com.example.holybibleapp.data

import com.example.holybibleapp.data.net.BookCloud
import com.example.holybibleapp.data.net.BooksService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface BooksCloudDataSource {
    suspend fun fetchBooks(): List<BookCloud>

    class Base(private val service: BooksService): BooksCloudDataSource {
        private val gson = Gson()
        private val type = object :TypeToken<List<BookCloud>>(){}.type
        override suspend fun fetchBooks(): List<BookCloud> =
            gson.fromJson(service.fetchBooks().string(),type)
    }
}