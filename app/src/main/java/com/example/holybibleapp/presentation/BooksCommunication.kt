package com.example.holybibleapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.holybibleapp.core.Abstract

interface BooksCommunication:Abstract.Mapper {
    fun map(books: List<BookUi>)

    fun observe(owner: LifecycleOwner, observer: Observer<List<BookUi>>)

    class Base: BooksCommunication {

        private val listLiveData = MutableLiveData<List<BookUi>>()


        override fun map(books: List<BookUi>) {
            listLiveData.value = books
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<BookUi>>) {
            listLiveData.observe(owner, observer)
        }


    }
}