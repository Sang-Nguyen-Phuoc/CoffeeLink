package com.example.coffee4n.ui.detail

import com.example.coffee4n.model.CoffeeItem

data class DetailState(
    val coffeeItems: List<CoffeeItem> = emptyList()
)