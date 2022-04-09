package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.example.holybibleapp.domain.BookDomain
import retrofit2.HttpException
import java.net.UnknownHostException

interface BooksDataToDomainMapper: Abstract.Mapper {

    fun map(book:List<Book>): BookDomain
    fun map(e:Exception): BookDomain
}