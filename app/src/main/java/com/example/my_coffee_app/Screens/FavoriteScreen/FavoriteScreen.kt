package com.example.my_coffee_app.Screens.FavoriteScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.my_coffee_app.ui_components.MyBottomNavBar
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

@Composable
fun FavoritesScreen(navController: NavHostController, viewModel: CoffeeViewModel) {

    // ✅ Real favorites from ViewModel
    val favoriteProducts by viewModel.favorites.collectAsState()

    Scaffold(
        topBar = { FavoritesScreenTopAppBar() },
        bottomBar = { MyBottomNavBar(navController = navController, "Favorites") }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                favoriteProducts.forEach { product ->
                    FavoriteItemCart(
                        product = product,
                        onRemove = { viewModel.toggleFavorite(product) } // ✅ ViewModel handles
                    )
                }
            }
        }
    }
}