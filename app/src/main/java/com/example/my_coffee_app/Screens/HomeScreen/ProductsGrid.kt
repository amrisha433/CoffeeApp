package com.example.my_coffee_app.Screens.HomeScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.my_coffee_app.domain.Model.Product

//@Preview
@Composable
fun ProductGrid(
    products: List<Product>,
    navController: NavController,
    topContent: @Composable () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
    ) {
        item{
            topContent()
        }
        items(products.chunked(2)){
            rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ProductCard(
                    products = rowItems[0],
                    modifier = Modifier.weight(1f),
                    navController = navController
                )
                if (rowItems.size == 2) {
                    ProductCard(
                        products = rowItems[1],
                        modifier = Modifier.weight(1f),
                        navController = navController
                    )
                }else{
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}