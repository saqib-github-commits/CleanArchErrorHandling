package com.cleanarch.errorhandling

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cleanarch.errorhandling.models.Book
import com.cleanarch.errorhandling.ui.common.ErrorView
import com.cleanarch.errorhandling.ui.common.LoadingView
import com.cleanarch.errorhandling.ui.common.UiDataState
import com.cleanarch.errorhandling.viewModel.BooksViewModel

@Composable
fun BooksScreen(viewModel: BooksViewModel = BooksViewModel()) {
    // state hoisting
    val uiDataState by viewModel.books.collectAsState()

    BooksScreen(uiDataState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksScreen(uiDataState: UiDataState<List<Book>>) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(text = "Books")}) }
    ) { PaddingValues ->
       Column(
           modifier = Modifier.padding(PaddingValues)
       ) {
           when (uiDataState) {
               is UiDataState.Loading -> LoadingView()
               is UiDataState.Loaded -> BooksList(uiDataState.data)
               is UiDataState.Error -> ErrorView(uiDataState.error, {})
           }
       }
    }
}