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
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: CoffeeViewModel) {
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
                Product(id=1, name="Espresso", description="Strong and Rich", imageResource =R.drawable.coffee_2, price=2.99, category="Espresso"),
                Product(id=2, name="Cappuccino", description="Smooth and Creamy", imageResource =R.drawable.coffee_3, price=3.99, category="Latte"),
                Product(id=3, name="Latte", description="Creamy and Cold", imageResource =R.drawable.coffee_4, price=4.99, category="Latte"),
                Product(id=4, name="Mocha", description="Espresso with Chocolate", imageResource =R.drawable.coffee_5, price=5.99, category="Latte"),
                Product(id=5, name="Americano", description="Espresso Shot", imageResource =R.drawable.coffee_6, price=6.99, category="Americano"),
                Product(id=6, name="Macchiato", description="Espresso with Foam", imageResource =R.drawable.coffee_1, price=7.99, category="Macchiato"),
                Product(id=7, name="Iced Coffee", description="Cold and Iced", imageResource =R.drawable.coffee_4, price=8.99, category="Americano"),
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