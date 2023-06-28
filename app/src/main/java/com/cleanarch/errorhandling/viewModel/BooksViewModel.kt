package com.cleanarch.errorhandling.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanarch.errorhandling.models.Books
import com.cleanarch.errorhandling.repository.BooksRepository
import com.cleanarch.errorhandling.repository.BooksRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class BooksViewModel (
    private val booksRepository: BooksRepository = BooksRepositoryImpl()
): ViewModel() {

    private val _books = MutableStateFlow<List<Books>>(emptyList())
    val books: StateFlow<List<Books>> = _books.asStateFlow()

    init {
        viewModelScope.launch {
            booksRepository.getBooks().catch {}.collect { _books.value = it }
        }
    }

}