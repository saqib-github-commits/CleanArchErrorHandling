package com.cleanarch.errorhandling.network

import com.cleanarch.errorhandling.models.Books
import kotlinx.coroutines.flow.Flow

interface BooksApi {

    fun fetchBooks(): Flow<List<Books>>

}