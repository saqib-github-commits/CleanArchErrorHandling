package com.cleanarch.errorhandling

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cleanarch.errorhandling.models.Books
import com.cleanarch.errorhandling.viewModel.BooksViewModel

@Composable
fun NewsScreen(viewModel: BooksViewModel = BooksViewModel()) {

    val books by viewModel.books.collectAsState() //TODO: with lifecycle aware api?
    LazyColumn {
        items(books) { BookCard(it) }
    }

}

@Composable
fun BookCard(books: Books) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = books.title)
    }
}

@Preview
@Composable
fun PreviewBookCard() {
    BookCard(books = Books("title"))
}