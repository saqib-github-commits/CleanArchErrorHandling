package com.cleanarch.errorhandling.repository

import com.cleanarch.errorhandling.common.Resource
import com.cleanarch.errorhandling.models.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(): Flow<Resource<List<Book>>>

}