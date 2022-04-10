package com.example.holybibleapp.data

import com.example.holybibleapp.core.Book
import com.example.holybibleapp.data.cache.BookCacheMapper
import com.example.holybibleapp.data.cache.BookDb
import com.example.holybibleapp.data.net.BookCloudMapper

abstract class BaseBooksRepositoryTest {
    protected inner class TestBookCacheMapper : BookCacheMapper {
        override fun map(bookDb: BookDb) = Book(bookDb.id, bookDb.name)
    }

    protected inner class TestBookCloudMapper : BookCloudMapper {
        override fun map(id: Int, name: String) = Book(id, name)
    }
}