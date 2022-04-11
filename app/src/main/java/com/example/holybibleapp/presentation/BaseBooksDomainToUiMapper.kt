package com.example.holybibleapp.presentation

import com.example.holybibleapp.domain.BookDomain
import com.example.holybibleapp.domain.BookDomainToUiMapper
import com.example.holybibleapp.domain.BooksDomainToUiMapper
import com.example.holybibleapp.domain.ErrorType

class BaseBooksDomainToUiMapper(private val resourceProvider: ResourceProvider,private val bookMapper: BookDomainToUiMapper):BooksDomainToUiMapper {
    override fun map(books: List<BookDomain>) = BooksUi.Success(books,bookMapper)
    override fun map(errorType: ErrorType)= BooksUi.Fail(errorType,resourceProvider)
}