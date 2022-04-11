package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.BookData
import com.example.holybibleapp.data.ToBookMapper

interface BooksCacheMapper:Abstract.Mapper {

    fun map(books:List<Abstract.Object<BookData, ToBookMapper>>):List<BookData>

    class Base(private val mapper:ToBookMapper) : BooksCacheMapper{
        override fun map(books: List<Abstract.Object<BookData,ToBookMapper>>) = books.map { bookDb ->
            bookDb.map(mapper)
        }
    }
}