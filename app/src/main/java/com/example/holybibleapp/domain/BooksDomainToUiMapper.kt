package com.example.holybibleapp.domain

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.presentation.BooksUi

interface BooksDomainToUiMapper:Abstract.Mapper{
    fun map(books: List<BookDomain>): BooksUi
    fun map(errorType:ErrorType): BooksUi
}