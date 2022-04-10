package com.example.holybibleapp.domain

import com.example.holybibleapp.core.Book
import com.example.holybibleapp.data.BooksDataToDomainMapper

class BaseBooksDataToDomainMapper:BooksDataToDomainMapper {
    override fun map(books: List<Book>) = BooksDomain.Success(books)
    override fun map(e: Exception) = BooksDomain.Fail(e)
}