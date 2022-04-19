package com.example.holybibleapp.domain

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.BookData
import com.example.holybibleapp.data.BookDataToDomainMapper
import com.example.holybibleapp.data.TestamentTemp
import com.example.holybibleapp.presentation.BooksUi
import retrofit2.HttpException
import java.net.UnknownHostException


sealed class BooksDomain : Abstract.Object<BooksUi, BooksDomainToUiMapper> {
    class Success(
        private val books: List<BookData>,
        private val bookMapper: BookDataToDomainMapper
    ) : BooksDomain() {

        override fun map(mapper: BooksDomainToUiMapper): BooksUi {
            val data = mutableListOf<BookDomain>()
            val temp = TestamentTemp.Base()
            books.forEach { bookData ->
                if (!bookData.compare(temp)){
                    if (temp.isEmpty())
                    data.add(BookDomain.Testament(TestamentType.OLD))
                    else
                        data.add(BookDomain.Testament(TestamentType.NEW))
                     bookData.saveTestament(temp)
                }
                data.add(bookData.map(bookMapper))
            }
            return mapper.map(data)
        }
    }


    class Fail(private val e: Exception) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }
}
