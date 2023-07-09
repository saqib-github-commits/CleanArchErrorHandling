package com.cleanarch.errorhandling.network

import com.cleanarch.errorhandling.common.Resource
import com.cleanarch.errorhandling.models.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import kotlin.random.Random

interface BooksRemoteDataSource {
    fun fetchBooks(): Flow<Resource<List<Book>>>
}

class BooksRemoteDataSourceImpl: BooksRemoteDataSource {

    override fun fetchBooks() = flow {
        when (Random.nextBoolean()) {
            true -> emit(Resource.Success(listOf(Book("title1"), Book("title2"))))
            false -> throw IOException()
        }
    }.flowOn(Dispatchers.IO)
}