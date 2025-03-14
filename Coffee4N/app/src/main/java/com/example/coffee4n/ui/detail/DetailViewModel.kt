package com.example.coffee4n.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffee4n.model.CoffeeItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState> = _state.asStateFlow()

    init {
        // Tải dữ liệu mẫu (giả lập)
        loadCoffeeItems()
    }

    private fun loadCoffeeItems() {
        viewModelScope.launch {
            val coffeeList = listOf(
                CoffeeItem("1", "Espresso", 2.5),
                CoffeeItem("2", "Latte", 3.0),
                CoffeeItem("3", "Cappuccino", 3.5)
            )
            _state.value = _state.value.copy(coffeeItems = coffeeList)
        }
    }
}