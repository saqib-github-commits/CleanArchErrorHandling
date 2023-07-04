package com.cleanarch.errorhandling.repository

import com.cleanarch.errorhandling.common.Resource
import com.cleanarch.errorhandling.common.extensions.toErrorType
import com.cleanarch.errorhandling.network.BooksApi
import com.cleanarch.errorhandling.network.BooksApiImpl
import kotlinx.coroutines.flow.catch

class BooksRepositoryImpl(
    private val booksApi: BooksApi = BooksApiImpl()
) : BooksRepository {

    override fun getBooks()= booksApi.fetchBooks().catch {
        emit(Resource.Error(it.toErrorType()))
    }
}