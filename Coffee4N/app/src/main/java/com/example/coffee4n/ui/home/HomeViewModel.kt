package com.example.coffee4n.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffee4n.model.CoffeeItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        // Tải dữ liệu mẫu khi khởi tạo
        loadCoffeeItems()
    }

    private fun loadCoffeeItems() {
        viewModelScope.launch {
            // Dữ liệu mẫu (sau này có thể thay bằng gọi repository)
            val coffeeList = listOf(
                CoffeeItem("1", "Espresso", 2.5),
                CoffeeItem("2", "Latte", 3.0),
                CoffeeItem("3", "Cappuccino", 3.5)
            )
            _state.value = _state.value.copy(coffeeItems = coffeeList)
        }
    }

    fun updateGreeting(newText: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(greetingText = newText)
        }
    }
}