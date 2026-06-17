package com.example.my_coffee_app.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.my_coffee_app.Screens.AiScreen.AiScreen
import com.example.my_coffee_app.Screens.CartScreen.CartScreen
import com.example.my_coffee_app.Screens.DetailsScreen.DetailsScreen
import com.example.my_coffee_app.Screens.FavoriteScreen.FavoritesScreen
import com.example.my_coffee_app.Screens.HomeScreen.HomeScreen
import com.example.my_coffee_app.Screens.ProfileScreen.ProfileScreen
import com.example.my_coffee_app.Screens.WelcomeScreen.WelcomeScreen
import com.example.my_coffee_app.viewmodel.CoffeeViewModel
//import com.example.my_coffee_app.Screens.AiScreen.AiScreen

@Composable
fun NavGraph(viewModel: CoffeeViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen) {
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }
        composable<Routes.HomeScreen> {
            HomeScreen(navController, viewModel)        // ← added viewModel
        }
        composable<Routes.DetailsScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailsScreen>()
            DetailsScreen(
                productId = args.productId,
                navController = navController,
                viewModel = viewModel                   // ← added viewModel
            )
        }
        composable<Routes.CartScreen> {
            CartScreen(navController, viewModel)        // ← added viewModel
        }
        composable<Routes.FavoritesScreen> {
            FavoritesScreen(navController, viewModel)   // ← added viewModel
        }
        composable<Routes.ProfileScreen> {
            ProfileScreen(navController)                // no viewModel needed
        }

        composable<Routes.AiScreen> {
            AiScreen(
                navController = navController,
                coffeeViewModel = viewModel
            )
        }
    }
}