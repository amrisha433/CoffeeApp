package com.example.my_coffee_app.Screens.CartScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_coffee_app.R
import com.example.my_coffee_app.domain.Model.Product
import com.example.my_coffee_app.ui.theme.LightBrown
import com.example.my_coffee_app.ui_components.MyBottomNavBar
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartScreen(navController: NavHostController, viewModel: CoffeeViewModel) {
    val CartProducts = listOf(
        Product(id=1,"Espresso","Strong and Rich", R.drawable.coffee_2, 2.99, category ="Espresso" ),
        Product(id=2,"Cappuccino","Smooth and Creamy", R.drawable.coffee_3, 3.99, category = "Cappuccino"),
        Product(id=3,"Latte","Creamy and Cold", R.drawable.coffee_4, 4.99, category = "Latte")
    )
    var amount by remember { mutableStateOf(12.50) }
    var deliveryFee by remember { mutableStateOf(1.00) }
    var totalAmount by remember { mutableStateOf(amount + deliveryFee) }

    Scaffold(
        topBar = {CartScreenTopAppBar(navController)},
        bottomBar = { MyBottomNavBar(navController=navController,"Cart") }
    ){innerpadding ->
        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .padding(innerpadding)
        ) {
            item {
                Row() {
                    Text(
                        "Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                CartProducts.forEach { product ->
                    CartItemCard(product)
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Payment Summary",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.titleMedium
                        .copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Price",
                        fontSize = 18.sp,
                    )
                    Text(
                        "$ $amount",
                        fontSize = 18.sp,

                        )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Delivery Fee",
                        fontSize = 18.sp,

                        )
                    Text(
                        "$ $deliveryFee",
                        fontSize = 18.sp,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                PaymentModeSelectionCard(totalAmount)
            }
        }
    }
}