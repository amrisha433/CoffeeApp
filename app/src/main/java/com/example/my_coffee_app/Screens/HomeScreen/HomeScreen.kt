package com.example.my_coffee_app.Screens.HomeScreen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_coffee_app.domain.Model.Product
import com.example.my_coffee_app.R
import com.example.my_coffee_app.ui_components.MyBottomNavBar

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(navController: NavHostController) {
    var location = "JSS Noida-62,UP,India"
    Scaffold(
        bottomBar = { MyBottomNavBar(navController,"Home") }
    ){innerpading ->
        Box(
           modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight(1/3f)
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
                .padding(innerpading)
        ) {

            // displaying product
            val products = listOf(
                Product(id=1,"Espresso","Strong and Rich", R.drawable.coffee_2, 2.99),
                Product(id=2,"Cappuccino","Smooth and Creamy", R.drawable.coffee_3, 3.99),
                Product(id=3,"Latte","Creamy and Cold", R.drawable.coffee_4, 4.99),
                Product(id=4,"Mocha","Espresso with Chocolate", R.drawable.coffee_5, 5.99),
                Product(id=5,"Americano","Espresso Shot", R.drawable.coffee_6, 6.99),
                Product(id=6,"Macchiato","Espresso with Foam", R.drawable.coffee_1, 7.99),
                Product(id=7,"Iced Coffee","Cold and Iced", R.drawable.coffee_4, 8.99),
            )
            ProductGrid(products = products,navController = navController){
                Text(text = "Location",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text=location,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp)
                    Icon(imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change Location",
                        tint = Color.White)
                }
                Spacer(modifier = Modifier.height(30.dp))
                MySearchBar()
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Home Banner"
                )
                Spacer(modifier = Modifier.height(16.dp))
                HomeScreenCategoryPremium()

            }
        }
    }
}