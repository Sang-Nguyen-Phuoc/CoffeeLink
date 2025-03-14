package com.example.coffee4n.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffee4n.model.CoffeeItem
import com.example.coffee4n.ui.theme.Coffee4NTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    onItemClick: (String) -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(modifier = modifier.padding(16.dp)) {
        // Hiển thị greeting text
        Text(text = state.greetingText)

        // Nút thay đổi greeting
        Button(
            onClick = { viewModel.updateGreeting("Hello Coffee4N!") },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Change Greeting")
        }

        // Danh sách Coffee Items
        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(state.coffeeItems) { coffeeItem ->
                CoffeeItemRow(
                    coffeeItem = coffeeItem,
                    onClick = { onItemClick(coffeeItem.id) }
                )
            }
        }
    }
}

@Composable
fun CoffeeItemRow(
    coffeeItem: CoffeeItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(vertical = 8.dp)
    ) {
        Text(text = "${coffeeItem.name} - $${coffeeItem.price}")
        Button(onClick = onClick) {
            Text("View Detail")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Coffee4NTheme {
        HomeScreen()
    }
}