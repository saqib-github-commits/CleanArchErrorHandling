package com.cleanarch.errorhandling.repository

import com.cleanarch.errorhandling.models.Books
import com.cleanarch.errorhandling.network.BooksApi
import com.cleanarch.errorhandling.network.BooksApiImpl
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val booksApi: BooksApi = BooksApiImpl()
) : BooksRepository {

    override fun getBooks(): Flow<List<Books>> = booksApi.fetchBooks()

}