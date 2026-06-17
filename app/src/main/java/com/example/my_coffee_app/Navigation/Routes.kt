package com.example.my_coffee_app.Navigation

import kotlinx.serialization.Serializable

sealed class Routes{

    @Serializable
    object WelcomeScreen : Routes()
    @Serializable
    object HomeScreen : Routes()

    @Serializable
    data class DetailsScreen(val productId: Int) : Routes()
    @Serializable
    object CartScreen: Routes()
    @Serializable
    object ProfileScreen: Routes()
    @Serializable
    object FavoritesScreen: Routes()
    @Serializable
    object AiScreen: Routes()
}