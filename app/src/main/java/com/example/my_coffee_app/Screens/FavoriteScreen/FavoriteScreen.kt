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
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

@Composable
fun FavoritesScreen(navController: NavHostController, viewModel: CoffeeViewModel) {
    var FavoriteProducts by remember {
        mutableStateOf(
            listOf(
                Product(id=1, name="Espresso", description="Strong and Rich", imageResource =R.drawable.coffee_2, price=2.99, category="Espresso"),
                Product(id=2, name="Cappuccino", description="Smooth and Creamy", imageResource =R.drawable.coffee_3, price=3.99, category="Latte"),
                Product(id=3, name="Latte", description="Creamy and Cold", imageResource =R.drawable.coffee_4, price=4.99, category="Latte"),
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