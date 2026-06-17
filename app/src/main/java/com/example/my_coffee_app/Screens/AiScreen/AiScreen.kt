package com.example.my_coffee_app.Screens.AiScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.my_coffee_app.viewmodel.CoffeeViewModel
import com.example.my_coffee_app.viewmodel.GeminiViewModel

@Composable
fun AiScreen(
    navController: NavHostController,
    coffeeViewModel: CoffeeViewModel,
    geminiViewModel: GeminiViewModel = viewModel()
) {
    val suggestion by geminiViewModel.suggestion.collectAsState()
    val isLoading by geminiViewModel.isLoading.collectAsState()
    var mood by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF1F1F1F), Color(0xFF121212))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Back button + Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Text(
                    text = "AI Coffee Suggester ☕",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "How are you feeling today?",
                color = Color.Gray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = mood,
                onValueChange = { mood = it },
                label = { Text("Your mood", color = Color.Gray) },
                placeholder = { Text("e.g. I'm feeling tired", color = Color.Gray) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color(0xFFB5763A),
                    unfocusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { geminiViewModel.getSuggestion(mood) },
                enabled = mood.isNotBlank() && !isLoading,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB5763A)
                )
            ) {
                Text(
                    text = if (isLoading) "Finding your coffee..." else "Suggest My Coffee",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (isLoading) {
                CircularProgressIndicator(color = Color(0xFFB5763A))
            }

            if (suggestion.isNotEmpty() && !isLoading) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF2C2C2C)
                    )
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "✨ Your Perfect Coffee",
                            color = Color(0xFFB5763A),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = suggestion,
                            color = Color.White,
                            fontSize = 15.sp,
                            lineHeight = 22.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                val coffeeName = suggestion
                                    .lines()
                                    .firstOrNull { it.startsWith("Coffee:") }
                                    ?.removePrefix("Coffee:")
                                    ?.trim() ?: ""
                                // find product and add to cart
                                coffeeViewModel.products.value
                                    .find { it.name.contains(coffeeName, ignoreCase = true) }
                                    ?.let { coffeeViewModel.addToCart(it) }
                                navController.popBackStack()
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFB5763A)
                            )
                        ) {
                            Text("Add to Cart", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}