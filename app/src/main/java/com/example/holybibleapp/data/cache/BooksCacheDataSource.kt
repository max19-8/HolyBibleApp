package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Book


interface BooksCacheDataSource {

    fun fetchBooks(): List<BookDb>

    fun saveBooks(books: List<Book>)

    class Base(private val realmProvider: RealmProvider) : BooksCacheDataSource {
        override fun fetchBooks(): List<BookDb> {
            realmProvider.provide().use { realm ->
                val bookDb = realm.where(BookDb::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(bookDb)
            }
        }

        override fun saveBooks(books: List<Book>) = realmProvider.provide().use { realm ->
                realm.executeTransaction {
                    books.forEach { book ->
                        val bookDb = it.createObject(BookDb::class.java, book.id)
                        bookDb.name = book.name
                    }

                }

            }
    }
}