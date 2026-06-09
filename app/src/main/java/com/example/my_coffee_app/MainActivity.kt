package com.example.my_coffee_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.my_coffee_app.Navigation.NavGraph
import com.example.my_coffee_app.ui.theme.My_Coffee_AppTheme
import com.example.my_coffee_app.viewmodel.CoffeeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My_Coffee_AppTheme {
                val viewModel: CoffeeViewModel by viewModels()  // ← ADD THIS
                NavGraph(viewModel = viewModel)                  // ← ADD THIS
            }
        }
    }
}

