package com.example.my_coffee_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_coffee_app.domain.Model.Product
import com.example.my_coffee_app.domain.Model.data.repository.CoffeeRepository
import kotlinx.coroutines.flow.*



data class CartItem(
    val product: Product,
    val quantity: Int = 1,
    val size: String = "M"
)

class CoffeeViewModel : ViewModel() {

    private val repository = CoffeeRepository()

    // Products
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    // Cart
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems.asStateFlow()

    // Favorites
    private val _favorites = MutableStateFlow<List<Product>>(emptyList())
    val favorites: StateFlow<List<Product>> = _favorites.asStateFlow()

    // Selected Category
    private val _selectedCategory = MutableStateFlow("All Coffees")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    // Payment Method
    private val _paymentMethod = MutableStateFlow("Online")
    val paymentMethod: StateFlow<String> = _paymentMethod.asStateFlow()

    // Total Price
    val totalPrice: StateFlow<Double> = _cartItems.map { items ->
        items.sumOf { it.product.price * it.quantity } + 1.0
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 1.0)

    // Cart Count
    val cartCount: StateFlow<Int> = _cartItems.map { items ->
        items.sumOf { it.quantity }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    init {
        loadProducts()
    }

    private fun loadProducts() {
        _products.value = repository.getAllProducts()
    }

    fun selectCategory(category: String) {
        _selectedCategory.value = category
        _products.value = repository.getProductsByCategory(category)
    }

    fun addToCart(product: Product, size: String = "M") {
        val current = _cartItems.value.toMutableList()
        val existing = current.find {
            it.product.id == product.id && it.size == size
        }
        if (existing != null) {
            val index = current.indexOf(existing)
            current[index] = existing.copy(quantity = existing.quantity + 1)
        } else {
            current.add(CartItem(product, 1, size))
        }
        _cartItems.value = current
    }

    fun increaseQuantity(item: CartItem) {
        _cartItems.value = _cartItems.value.map {
            if (it == item) it.copy(quantity = it.quantity + 1) else it
        }
    }

    fun decreaseQuantity(item: CartItem) {
        val current = _cartItems.value.toMutableList()
        val existing = current.find { it == item }
        if (existing != null) {
            if (existing.quantity > 1) {
                val index = current.indexOf(existing)
                current[index] = existing.copy(quantity = existing.quantity - 1)
            } else {
                current.remove(existing)
            }
        }
        _cartItems.value = current
    }

    fun toggleFavorite(product: Product) {
        val current = _favorites.value.toMutableList()
        if (current.contains(product)) current.remove(product)
        else current.add(product)
        _favorites.value = current
    }

    fun isFavorite(product: Product): Boolean {
        return _favorites.value.contains(product)
    }

    fun setPaymentMethod(method: String) {
        _paymentMethod.value = method
    }

    fun placeOrder() {
        _cartItems.value = emptyList()
    }
}