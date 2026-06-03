package com.example.my_coffee_app.Screens.ProfileScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)

@Composable
fun ProfileScreenTopAppBar() {

    TopAppBar(
        title = {
            Text(
                "Profile",
                fontWeight = FontWeight.Bold
            )
        }
    )
}
