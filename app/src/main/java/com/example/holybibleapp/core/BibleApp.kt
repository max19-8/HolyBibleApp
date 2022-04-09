package com.example.holybibleapp.core

import android.app.Application
import com.example.holybibleapp.data.BooksRepository
import com.example.holybibleapp.domain.BaseBooksDataToDomainMapper
import com.example.holybibleapp.domain.BooksInteractor

class BibleApp:Application() {

    override fun onCreate() {
        super.onCreate()


        val booksRepository:BooksRepository = TODO("merge")
        val booksInteractor = BooksInteractor.Base(booksRepository,BaseBooksDataToDomainMapper())
    }
}