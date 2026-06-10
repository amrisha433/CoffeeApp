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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_coffee_app.ui.theme.LightBrown
import com.example.my_coffee_app.ui_components.MyBottomNavBar
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

@Composable
fun CartScreen(navController: NavHostController, viewModel: CoffeeViewModel) {

    // ✅ Real data from ViewModel
    val cartItems by viewModel.cartItems.collectAsState()
    val totalPrice by viewModel.totalPrice.collectAsState()
    val deliveryFee = 1.00
    val amount = totalPrice - deliveryFee

    Scaffold(
        topBar = { CartScreenTopAppBar(navController) },
        bottomBar = { MyBottomNavBar(navController = navController, "Cart") }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .padding(innerPadding)
        ) {
            item {
                Row {
                    Text(
                        "Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                // ✅ Real cart items from ViewModel
                cartItems.forEach { cartItem ->
                    CartItemCard(
                        cartItem = cartItem,
                        onIncrease = { viewModel.increaseQuantity(cartItem) },
                        onDecrease = { viewModel.decreaseQuantity(cartItem) }
                    )
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
                    Text("Price", fontSize = 18.sp)
                    Text("$ ${"%.2f".format(amount)}", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Delivery Fee", fontSize = 18.sp)
                    Text("$ ${"%.2f".format(deliveryFee)}", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(16.dp))
                PaymentModeSelectionCard(
                    totalAmount = totalPrice,
                    viewModel = viewModel     // ✅ for place order
                )
            }
        }
    }
}