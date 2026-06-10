package com.example.my_coffee_app.Screens.ProfileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_coffee_app.Navigation.Routes
import com.example.my_coffee_app.ui.theme.LightBrown
import com.example.my_coffee_app.ui_components.MyBottomNavBar

//@Preview(showBackground = true)
@Composable
fun ProfileScreen(navController: NavHostController) {
    //var location = "JSS College Noida-62,UP"
    Scaffold(
        topBar = { ProfileScreenTopAppBar() },
        bottomBar = { MyBottomNavBar(navController=navController,"Profile") }
    ) {innerpadding->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
                .padding(innerpadding)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(
                            color = LightBrown.copy(0.15f)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile Picture",
                        modifier = Modifier.size(80.dp),
                        tint = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Amrisha Maurya",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = "amrisha@example.com",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Address",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "JSS College, Noida-62,\nGautambuddha Nagar\nUP 201309",
                //style = MaterialTheme.typography.bodyLarge,
                //color = Color.DarkGray,
                fontSize = 20.sp,
                //fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray.copy(0.4f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth()
                        .clickable {
                            navController.navigate(Routes.CartScreen) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Cart",
                            tint = LightBrown,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "Cart",
                            style = MaterialTheme.typography.titleLarge,
                            //fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth()
                        .clickable {
                            navController.navigate(Routes.FavoritesScreen) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Favorite,
                            contentDescription = "favorite",
                            tint = LightBrown,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "Favorites",
                            style = MaterialTheme.typography.titleLarge,
                            //fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth().clickable{ }) {
                        Icon(imageVector = Icons.Default.WbSunny,
                            contentDescription = "Theme",
                            tint = LightBrown,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "Change Theme",
                            style = MaterialTheme.typography.titleLarge,
                            //fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth().clickable{ }) {
                        Icon(imageVector = Icons.Default.Settings,
                            contentDescription = "Setting",
                            tint = LightBrown,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = "Settings",
                            style = MaterialTheme.typography.titleLarge,
                            //fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}