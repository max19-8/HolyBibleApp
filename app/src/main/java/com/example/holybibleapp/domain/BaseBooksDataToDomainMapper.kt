package com.example.holybibleapp.domain

import com.example.holybibleapp.data.BookData
import com.example.holybibleapp.data.BookDataToDomainMapper
import com.example.holybibleapp.data.BooksDataToDomainMapper

class BaseBooksDataToDomainMapper(private val bookMapper:BookDataToDomainMapper):BooksDataToDomainMapper {
    override fun map(books: List<BookData>) = BooksDomain.Success(books,bookMapper)
    override fun map(e: Exception) = BooksDomain.Fail(e)
}