package com.example.my_coffee_app.data.repository

import com.example.my_coffee_app.R
import com.example.my_coffee_app.domain.Model.Product

class CoffeeRepository {

    fun getAllProducts(): List<Product> {
        return listOf(
            Product(
                id = 1,
                name = "Espresso",
                description = "Strong and Rich",
                imageResource = R.drawable.coffee_2,
                price = 2.99,
                category = "Espresso"
            ),
            Product(
                id = 2,
                name = "Cappuccino",
                description = "Smooth and Creamy",
                imageResource = R.drawable.coffee_3,
                price = 3.99,
                category = "Latte"
            ),
            Product(
                id = 3,
                name = "Latte",
                description = "Creamy and Cold",
                imageResource = R.drawable.coffee_4,
                price = 4.99,
                category = "Latte"
            ),
            Product(
                id = 4,
                name = "Mocha",
                description = "Espresso with Chocolate",
                imageResource = R.drawable.coffee_5,
                price = 5.99,
                category = "Latte"
            ),
            Product(
                id = 5,
                name = "Americano",
                description = "Espresso Shot",
                imageResource = R.drawable.coffee_6,
                price = 6.99,
                category = "Americano"
            ),
            Product(
                id = 6,
                name = "Macchiato",
                description = "Espresso with Foam",
                imageResource = R.drawable.coffee_1,
                price = 7.99,
                category = "Macchiato"
            ),
            Product(
                id = 7,
                name = "Iced Coffee",
                description = "Cold and Iced",
                imageResource = R.drawable.coffee_4,
                price = 8.99,
                category = "Americano"
            ),
        )
    }

    fun getProductsByCategory(category: String): List<Product> {
        return if (category == "All Coffees") getAllProducts()
        else getAllProducts().filter { it.category == category }
    }
}