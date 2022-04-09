package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book

interface BookCacheMapper:Abstract.Mapper {

    fun map(bookDb: BookDb):Book

    class Base:BookCacheMapper {
        override fun map(bookDb: BookDb) = Book(bookDb.id,bookDb.name)
    }
}