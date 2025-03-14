package com.example.coffee4n.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffee4n.ui.theme.Coffee4NTheme

@Composable
fun DetailScreen(
    itemId: String,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    // Tìm CoffeeItem dựa trên itemId (giả lập)
    val coffeeItem = state.coffeeItems.find { it.id == itemId }

    if (coffeeItem != null) {
        Text(
            text = "Detail for ${coffeeItem.name}: $${coffeeItem.price}",
            modifier = modifier
        )
    } else {
        Text(
            text = "Item not found for ID: $itemId",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Coffee4NTheme {
        DetailScreen(itemId = "1")
    }
}