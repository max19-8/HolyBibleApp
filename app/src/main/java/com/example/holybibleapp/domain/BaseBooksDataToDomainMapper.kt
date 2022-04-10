package com.example.holybibleapp.domain

import com.example.holybibleapp.core.Book
import com.example.holybibleapp.data.BooksDataToDomainMapper
import com.example.holybibleapp.presentation.BooksUi

class BaseBooksDataToDomainMapper:BooksDataToDomainMapper {
    override fun map(books: List<Book>): BookDomain {
        return BookDomain.Success(books)
    }

    override fun map(e: Exception): BookDomain {
        return BookDomain.Fail(e)
    }

}