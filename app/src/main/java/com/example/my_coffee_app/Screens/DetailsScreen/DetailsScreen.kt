package com.example.my_coffee_app.Screens.DetailsScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

@Composable
fun DetailsScreen(productId: Int, navController: NavController, viewModel: CoffeeViewModel) {

    // ✅ Get products from ViewModel
    val products by viewModel.products.collectAsState()

    val selectedProduct = products.find { it.id == productId }
        ?: run {
            Text("Product not found", color = Color.Red)
            return
        }

    Scaffold(
        topBar = { DetailedScreenTopAppBar(navController) },
        bottomBar = {
            DetailedScreenBottomAppBar(
                navController = navController,
                product = selectedProduct,
                viewModel = viewModel        // ✅ for add to cart
            )
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                ProductDetailContent(
                    product = selectedProduct,
                    innerPadding = innerPadding,
                    viewModel = viewModel    // ✅ for favorite toggle
                )
            }
        }
    }
}