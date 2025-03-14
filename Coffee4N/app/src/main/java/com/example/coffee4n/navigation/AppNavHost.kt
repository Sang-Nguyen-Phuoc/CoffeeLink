package com.example.coffee4n.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffee4n.ui.detail.DetailScreen
import com.example.coffee4n.ui.home.HomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.HOME
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.HOME) {
            HomeScreen(
                onItemClick = { itemId ->
                    navController.navigate(Destinations.detailRoute(itemId))
                }
            )
        }
        composable(Destinations.DETAIL) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId") ?: "Unknown"
            DetailScreen(itemId = itemId)
        }
    }
}