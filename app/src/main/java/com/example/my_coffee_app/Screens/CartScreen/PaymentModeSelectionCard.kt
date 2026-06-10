package com.example.my_coffee_app.Screens.CartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_coffee_app.R
import com.example.my_coffee_app.ui.theme.LightBrown
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

@Composable
fun PaymentModeSelectionCard(
    totalAmount: Double,
    viewModel: CoffeeViewModel          // ✅ added viewModel
) {
    var expanded by remember { mutableStateOf(false) }
    val paymentModes = listOf("Online", "Cash on Delivery")

    // ✅ Payment method from ViewModel
    val selectedMode by viewModel.paymentMethod.collectAsState()

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(
                            if (selectedMode == "Online") R.drawable.mobile_banking
                            else R.drawable.wallet
                        ),
                        contentDescription = "Payment",
                        modifier = Modifier.size(30.dp),
                        tint = LightBrown
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            selectedMode,
                            fontSize = 24.sp,
                            style = MaterialTheme.typography.bodyMedium
                                .copy(fontWeight = FontWeight.SemiBold)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (selectedMode == "Online") "$ ${"%.2f".format(totalAmount)}"
                            else "$ ${"%.2f".format(totalAmount + 1.0)}",
                            fontSize = 20.sp,
                            color = LightBrown,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Box {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_arrow_down),
                        contentDescription = "change Payment mode",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { expanded = true }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        paymentModes.forEach { mode ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = mode,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                },
                                onClick = {
                                    viewModel.setPaymentMethod(mode) // ✅ ViewModel handles
                                    expanded = false
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(
                                            if (mode == "Online") R.drawable.mobile_banking
                                            else R.drawable.wallet
                                        ),
                                        contentDescription = null,
                                        tint = LightBrown,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .background(
                                        color = if (selectedMode == mode)
                                            LightBrown.copy(alpha = 0.2f)
                                        else Color.Transparent
                                    )
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { viewModel.placeOrder() }, // ✅ clears cart
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .shadow(10.dp, RoundedCornerShape(20.dp)),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD17842)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 4.dp
                )
            ) {
                Text(
                    text = "Place Order",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}