package com.example.my_coffee_app.Screens.HomeScreen

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import com.example.my_coffee_app.Navigation.Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_coffee_app.R
import com.example.my_coffee_app.ui_components.MyBottomNavBar
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: CoffeeViewModel) {
    var location = "JSS Noida-62,UP,India"

    // ✅ Get products from ViewModel
    val products by viewModel.products.collectAsState()

    Scaffold(
        bottomBar = { MyBottomNavBar(navController, "Home") }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1 / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
                .padding(innerPadding)
        ) {
            Button(
                onClick = { navController.navigate(Routes.AiScreen) },
                modifier = Modifier
                    .fillMaxWidth().height(55.dp)
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB5763A)
                )
            ) {
                Text("✨ AI Coffee Suggestion", fontWeight = FontWeight.Bold)
            }
            // ✅ products from ViewModel now
            ProductGrid(products = products, viewModel= viewModel,navController = navController) {
                Text(
                    text = "Location",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = location,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change Location",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                MySearchBar()
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Home Banner"
                )
                Spacer(modifier = Modifier.height(16.dp))
                HomeScreenCategoryPremium(viewModel=viewModel)
            }
        }
    }
}