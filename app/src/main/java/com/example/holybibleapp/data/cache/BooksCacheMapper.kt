package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book

interface BooksCacheMapper:Abstract.Mapper {

    fun map(books:List<BookDb>):List<Book>

    class Base(private val mapper:BookCacheMapper) : BooksCacheMapper{
        override fun map(books: List<BookDb>): List<Book> = books.map { bookDb ->
            bookDb.map(mapper)
        }
    }
    class Test(private val mapper:BookCacheMapper) : BooksCacheMapper{
        override fun map(books: List<BookDb>): List<Book> = books.map { bookDb ->
            bookDb.map(mapper)
        }
    }
}