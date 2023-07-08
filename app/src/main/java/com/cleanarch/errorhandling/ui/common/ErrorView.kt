package com.cleanarch.errorhandling.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cleanarch.errorhandling.R

@Composable
fun ErrorView(errorText: ErrorText, action: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = errorText.asString())
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            action() }
        ) {
            Text(text = "Retry")
        }
    }
}

@Composable
@Preview
fun PreviewErrorView() {
    ErrorView(ErrorText.StringResource(R.string.error_general)) { }
}