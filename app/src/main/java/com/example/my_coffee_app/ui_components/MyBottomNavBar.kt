package com.example.my_coffee_app.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my_coffee_app.R
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.my_coffee_app.Navigation.Routes
import com.example.my_coffee_app.ui.theme.LightBrown

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyBottomNavBar(navController: NavHostController,routes: String) {
    //bottom nav items
    val navItems = listOf(
        NavItem(title = "Home", icon = R.drawable.regular_outline_home, Routes.HomeScreen),
        NavItem(title = "Cart", icon = R.drawable.regular_outline_bag, Routes.CartScreen),
        //NavItem(title = "Search", icon = R.drawable.regular_outline_search),
        NavItem(title = "Favorite", icon = R.drawable.regular_outline_heart, Routes.FavoritesScreen),
        NavItem("Profile", icon = R.drawable.outline_account_circle_24,Routes.ProfileScreen)
        )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ) {
        navItems.forEachIndexed{index, item->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title
                    )
                },
                label = {Text(text = item.title)},
                modifier = Modifier.size(30.dp),
                //handeling bottom bar navigation
                onClick = {
                    navController.navigate(item.routes){{}
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = item.title == routes,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(0.15f)
                )
            )
        }
    }
}
data class NavItem(
    val title:String,
    val icon:Int,
    val routes : Routes
)