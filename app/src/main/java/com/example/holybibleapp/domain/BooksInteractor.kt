package com.example.holybibleapp.domain

import com.example.holybibleapp.data.BooksDataToDomainMapper
import com.example.holybibleapp.data.BooksRepository

interface BooksInteractor {

   suspend fun fetchBooks(): BookDomain

    class Base(private val books: BooksRepository,private val mapper:BooksDataToDomainMapper): BooksInteractor {
        override suspend fun fetchBooks(): BookDomain = books.fetchBooks().map(mapper)
    }
}
