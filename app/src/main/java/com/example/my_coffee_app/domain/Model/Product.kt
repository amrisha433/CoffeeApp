package com.example.my_coffee_app.domain.Model

public data class Product(
    val id:Int,
    val name:String,
    val description:String,
    val imageResource:Int,
    val price:Double,
    val category: String
)