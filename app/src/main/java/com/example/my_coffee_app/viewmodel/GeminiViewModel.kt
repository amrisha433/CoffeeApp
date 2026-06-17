package com.example.my_coffee_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_coffee_app.data.repository.GeminiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GeminiViewModel : ViewModel() {

    private val repository = GeminiRepository()

    private val _suggestion = MutableStateFlow("")
    val suggestion: StateFlow<String> = _suggestion

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getSuggestion(mood: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _suggestion.value = repository.getCoffeeSuggestion(mood)
            _isLoading.value = false
        }
    }
}