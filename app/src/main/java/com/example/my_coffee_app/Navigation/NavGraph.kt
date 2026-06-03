package com.example.my_coffee_app.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.my_coffee_app.Screens.CartScreen.CartScreen
import com.example.my_coffee_app.Screens.DetailsScreen.DetailsScreen
import com.example.my_coffee_app.Screens.FavoriteScreen.FavoritesScreen
import com.example.my_coffee_app.Screens.HomeScreen.HomeScreen
import com.example.my_coffee_app.Screens.ProfileScreen.ProfileScreen
import com.example.my_coffee_app.Screens.WelcomeScreen.WelcomeScreen


@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen) {
        composable <Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }
        composable <Routes.HomeScreen> {
            HomeScreen(navController)
        }
        composable <Routes.DetailsScreen> { backStackEntry ->
            var args = backStackEntry.toRoute<Routes.DetailsScreen>()

            DetailsScreen(productId = args.productId,navController)
        }
        composable<Routes.CartScreen> {
            CartScreen(navController)
        }
        composable <Routes.FavoritesScreen>{
            FavoritesScreen(navController)

        }
        composable <Routes.ProfileScreen>{
            ProfileScreen(navController)

        }

    }
}