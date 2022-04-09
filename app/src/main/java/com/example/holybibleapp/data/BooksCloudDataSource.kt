package com.example.holybibleapp.data

import com.example.holybibleapp.data.net.BookCloud
import com.example.holybibleapp.data.net.BooksService

interface BooksCloudDataSource {
    suspend fun fetchBooks(): List<BookCloud>

    class Base(private val service: BooksService): BooksCloudDataSource {
        override suspend fun fetchBooks() = service.fetchBooks()
    }
}