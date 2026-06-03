package com.example.my_coffee_app.Screens.FavoriteScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.my_coffee_app.R
import com.example.my_coffee_app.domain.Model.Product
import com.example.my_coffee_app.ui_components.MyBottomNavBar

@Composable
fun FavoritesScreen(navController: NavHostController) {
    var FavoriteProducts by remember {
        mutableStateOf(
            listOf(
                Product(id=1,"Espresso","Strong and Rich", R.drawable.coffee_2, 2.99),
                Product(id=2,"Cappuccino","Smooth and Creamy", R.drawable.coffee_3, 3.99),
                Product(id=3,"Latte","Creamy and Cold", R.drawable.coffee_4, 4.99)
            )
        )
    }
    Scaffold(
        topBar = { FavoritesScreenTopAppBar() },
        bottomBar = { MyBottomNavBar(navController=navController,"Favorites") }
    ) { innerpadding->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerpadding)
        ) {
            item {
                FavoriteProducts.forEach { product->
                    FavoriteItemCart(product,
                        onRemove = {FavoriteProducts=FavoriteProducts-product})
                }
            }
        }
    }
}
