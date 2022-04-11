package com.example.holybibleapp.data.cache

import com.example.holybibleapp.data.BookData
import com.example.holybibleapp.data.BookDataToDbMapper


interface BooksCacheDataSource {

    fun fetchBooks(): List<BookDb>

    fun saveBooks(books: List<BookData>)

    class Base(private val realmProvider: RealmProvider, private val mapper: BookDataToDbMapper) :
        BooksCacheDataSource {
        override fun fetchBooks(): List<BookDb> {
            realmProvider.provide().use { realm ->
                val bookDb = realm.where(BookDb::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(bookDb)
            }
        }

        override fun saveBooks(books: List<BookData>) = realmProvider.provide().use { realm ->
            realm.executeTransaction {
                books.forEach { book ->
                    book.mapTo(mapper,it)
                }
            }
        }
    }
}