package com.example.my_coffee_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.my_coffee_app.Navigation.NavGraph
import com.example.my_coffee_app.Screens.ProfileScreen.ProfileScreen
import com.example.my_coffee_app.ui.theme.My_Coffee_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            My_Coffee_AppTheme {
                NavGraph()
            }
        }
    }
}

