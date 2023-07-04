package com.cleanarch.errorhandling.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanarch.errorhandling.common.Resource
import com.cleanarch.errorhandling.models.Book
import com.cleanarch.errorhandling.repository.BooksRepository
import com.cleanarch.errorhandling.repository.BooksRepositoryImpl
import com.cleanarch.errorhandling.ui.common.UiDataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class BooksViewModel (
    private val booksRepository: BooksRepository = BooksRepositoryImpl()
): ViewModel() {

    private val _books = MutableStateFlow<UiDataState<List<Book>>>(UiDataState.Loading())
    val books: StateFlow<UiDataState<List<Book>>> = _books.asStateFlow()

    init {
        viewModelScope.launch {
            booksRepository.getBooks()
                .catch { }
                .collect {
                    when (it) {
                        is Resource.Success -> _books.value = UiDataState.Loaded(it.data)
                        is Resource.Error -> _books.value = UiDataState.Error("An Error occurred while loading data, Please try again")
                    }
                }
        }
    }

}