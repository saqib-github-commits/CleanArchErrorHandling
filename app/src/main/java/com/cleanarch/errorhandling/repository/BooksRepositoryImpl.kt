package com.cleanarch.errorhandling.repository

import com.cleanarch.errorhandling.common.Resource
import com.cleanarch.errorhandling.common.extensions.toErrorType
import com.cleanarch.errorhandling.network.BooksRemoteDataSource
import com.cleanarch.errorhandling.network.BooksRemoteDataSourceImpl
import kotlinx.coroutines.flow.catch

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource = BooksRemoteDataSourceImpl()
) : BooksRepository {

    override fun getBooks()= booksRemoteDataSource.fetchBooks().catch {
        emit(Resource.Error(it.toErrorType()))
    }
}