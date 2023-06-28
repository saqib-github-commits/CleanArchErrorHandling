package com.cleanarch.errorhandling.network

import com.cleanarch.errorhandling.models.Books
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class BooksApiImpl: BooksApi {

    override fun fetchBooks() = flow {
        emit(listOf(Books("title1"), Books("title2")))
    }.flowOn(Dispatchers.IO)
}