package com.cleanarch.errorhandling

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.cleanarch.errorhandling.models.Book

@Composable
fun BooksList(books: List<Book>) {
    LazyColumn {
        items(books) { BookCard(it) }
    }
}