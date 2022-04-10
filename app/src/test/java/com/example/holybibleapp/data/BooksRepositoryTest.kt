package com.example.holybibleapp.data

import com.example.holybibleapp.core.Book
import com.example.holybibleapp.data.cache.BookDb
import com.example.holybibleapp.data.cache.BooksCacheDataSource
import com.example.holybibleapp.data.cache.BooksCacheMapper
import com.example.holybibleapp.data.net.BookCloud
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.net.UnknownHostException

class BooksRepositoryTest:BaseBooksRepositoryTest() {

    private val unknownHostException = UnknownHostException()


    @Test
    fun test_no_connection_no_cache() = runBlocking {
        val testCloudDataSource = TestBooksCloudDataSource( false)
        val testCacheDataSource = TestBooksCacheDataSource(false)
        val repository = BooksRepository.Base(
            testCloudDataSource, testCacheDataSource,
            BooksCloudMapper.Base(TestBookCloudMapper()),
            BooksCacheMapper.Base(TestBookCacheMapper())
        )
        val actual = repository.fetchBooks()
        val expected = BooksData.Fail(unknownHostException)

        assertEquals(expected, actual)
    }

    @Test
    fun test_cloud_success_no_cache() = runBlocking {
        val testCloudDataSource = TestBooksCloudDataSource(true)
        val testCacheDataSource = TestBooksCacheDataSource(false)
        val repository = BooksRepository.Base(
            testCloudDataSource, testCacheDataSource,
            BooksCloudMapper.Base(TestBookCloudMapper()),
            BooksCacheMapper.Base(TestBookCacheMapper())
        )
        val actual = repository.fetchBooks()
        val expected = BooksData.Success(
            listOf(
                Book(0, "0"),
                Book(1, "1"),
                Book(2, "2")
            )
        )

        assertEquals(expected, actual)
    }


    @Test
    fun test_no_connection_with_cache() = runBlocking {
        val testCloudDataSource = TestBooksCloudDataSource(false)
        val testCacheDataSource = TestBooksCacheDataSource(true)
        val repository = BooksRepository.Base(
            testCloudDataSource, testCacheDataSource,
            BooksCloudMapper.Base(TestBookCloudMapper()),
            BooksCacheMapper.Base(TestBookCacheMapper())
        )
        val actual = repository.fetchBooks()
        val expected = BooksData.Success(
            listOf(
                Book(10, "name10"),
                Book(11, "name11"),
                Book(12, "name12")
            )
        )

        assertEquals(expected, actual)
    }

    @Test
    fun test_cloud_success_with_cache() = runBlocking {
        val testCloudDataSource = TestBooksCloudDataSource(true)
        val testCacheDataSource = TestBooksCacheDataSource(true)
        val repository = BooksRepository.Base(
            testCloudDataSource, testCacheDataSource,
            BooksCloudMapper.Base(TestBookCloudMapper()),
            BooksCacheMapper.Base(TestBookCacheMapper())
        )
        val actual = repository.fetchBooks()
        val expected = BooksData.Success(
            listOf(
                Book(10, "name10"),
                Book(11, "name11"),
                Book(12, "name12")
            )
        )

        assertEquals(expected, actual)
    }


    private inner class TestBooksCloudDataSource(
        private val returnSuccess: Boolean
    ) : BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> {
            if (returnSuccess) {
                return listOf(
                    BookCloud(0, "0"),
                    BookCloud(1, "1"),
                    BookCloud(2, "2")
                )
            } else {
                throw unknownHostException

            }
        }
    }

    private inner class TestBooksCacheDataSource(
        private val returnSuccess: Boolean
    ) : BooksCacheDataSource {
        override fun fetchBooks(): List<BookDb> {
            return if (returnSuccess)
                listOf(
                    BookDb().apply {
                        id = 10
                        name = "name10"
                    },
                    BookDb().apply {
                        id = 11
                        name = "name11"
                    },
                    BookDb().apply {
                        id = 12
                        name = "name12"
                    },
                )
            else
                emptyList()

        }

        override fun saveBooks(books: List<Book>) {
            //not used here
        }
    }
}