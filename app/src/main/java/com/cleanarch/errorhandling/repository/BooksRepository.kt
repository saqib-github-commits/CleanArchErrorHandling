package com.cleanarch.errorhandling.repository

import com.cleanarch.errorhandling.models.Books
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(): Flow<List<Books>>

}