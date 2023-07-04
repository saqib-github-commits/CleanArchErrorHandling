package com.cleanarch.errorhandling.network

import com.cleanarch.errorhandling.common.Resource
import com.cleanarch.errorhandling.models.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.HttpRetryException
import kotlin.random.Random

interface BooksApi {
    fun fetchBooks(): Flow<Resource<List<Book>>>
}

class BooksApiImpl: BooksApi {

    override fun fetchBooks() = flow {
        when (Random.nextBoolean()) {
            true -> emit(Resource.Success(listOf(Book("title1"), Book("title2"))))
            false -> throw IOException()
        }
    }.flowOn(Dispatchers.IO)
}