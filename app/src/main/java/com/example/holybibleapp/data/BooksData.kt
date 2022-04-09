package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.example.holybibleapp.domain.BookDomain

sealed class BooksData:Abstract.Object<BookDomain, BooksDataToDomainMapper>() {

    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(books)
    }

    class Fail(private val e: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(e)
    }
}