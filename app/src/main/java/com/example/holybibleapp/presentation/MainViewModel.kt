package com.example.holybibleapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.holybibleapp.domain.BooksDomainToUiMapper
import com.example.holybibleapp.domain.BooksInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val booksInteractor: BooksInteractor,
    private val mapper: BooksDomainToUiMapper,
    private val communication: BooksCommunication
):ViewModel() { //todo interface

    fun fetchBooks() {
        communication.map(listOf(BookUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
        val resultDomain = booksInteractor.fetchBooks()
       withContext(Dispatchers.Main){
            val resultUi = resultDomain.map(mapper)
            resultUi.map(communication)
        }
       }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<BookUi>>){
        communication.observe(owner, observer)
    }
}