package com.example.coffee4n.ui.home

import com.example.coffee4n.model.CoffeeItem

data class HomeState(
    val greetingText: String = "Hello Android!",
    val coffeeItems: List<CoffeeItem> = emptyList()
)