package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.example.holybibleapp.domain.BooksDomain

interface BooksDataToDomainMapper: Abstract.Mapper {

    fun map(books:List<Book>): BooksDomain
    fun map(e:Exception): BooksDomain
}