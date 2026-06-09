package com.example.my_coffee_app.Screens.DetailsScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.my_coffee_app.R
import com.example.my_coffee_app.domain.Model.Product
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsScreen(productId: Int, navController: NavController, viewModel: CoffeeViewModel) {

    val products = listOf(
        Product(1, "Espresso", "Strong and Rich", R.drawable.coffee_2, 2.99, "Espresso"),
        Product(2, "Cappuccino", "Smooth and Creamy", R.drawable.coffee_3, 3.99, "Latte"),
        Product(3, "Latte", "Creamy and Cold", R.drawable.coffee_4, 4.99, "Latte"),
        Product(4, "Mocha", "Espresso with Chocolate", R.drawable.coffee_5, 5.99, "Latte"),
        Product(5, "Americano", "Espresso Shot", R.drawable.coffee_6, 6.99, "Americano"),
        Product(6, "Macchiato", "Espresso with Foam", R.drawable.coffee_1, 7.99, "Macchiato"),
        Product(7, "Iced Coffee", "Cold and Iced", R.drawable.coffee_4, 8.99, "Americano"),
    )

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
                product = selectedProduct
            )
        }
    ) { innerPadding ->

        LazyColumn(contentPadding = innerPadding) {
            item {
                ProductDetailContent(selectedProduct, innerPadding)
            }
        }
    }
}