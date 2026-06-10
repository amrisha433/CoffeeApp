package com.example.my_coffee_app.Screens.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

@Composable
fun HomeScreenCategoryPremium(viewModel: CoffeeViewModel) {  // ✅ added viewModel

    val categories = listOf("All Coffees", "Macchiato", "Latte", "Americano", "Snacks", "Desserts")

    // ✅ Get selected category from ViewModel
    val selectedCategory by viewModel.selectedCategory.collectAsState()

    LazyRow(
        modifier = Modifier.padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            CategoryChip(
                text = category,
                isSelected = category == selectedCategory,  // ✅ dynamic now
                onSelected = { viewModel.selectCategory(category) }  // ✅ updates ViewModel
            )
        }
    }
}