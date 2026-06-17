package com.example.my_coffee_app.data.repository

import android.util.Log
import com.example.my_coffee_app.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel

class GeminiRepository {

    private val generativeModel = GenerativeModel(
        modelName = "gemini-2.5-flash-lite",
        apiKey = BuildConfig.GEMINI_API_KEY
    )

    suspend fun getCoffeeSuggestion(mood: String): String {
        return try {

            val prompt = """
                You are a friendly coffee expert.
                Based on the mood: "$mood"
                Suggest 1 different coffee from this list:
                Espresso, Cappuccino, Latte, Mocha, Americano, Macchiato, Iced Coffee
                
                Reply in exactly this format:
                1. Coffee: [name]
                   Reason: [one line fun reason]
            """.trimIndent()

            val response = generativeModel.generateContent(prompt)
            response.text ?: "Try our special Espresso today!"

        } catch (e: Exception) {
            if (e.message?.contains("503") == true) {
                return "AI service is busy right now. Please try again in a few seconds."
            }
            return "Sorry, our AI barista is busy right now. Please try again!"
        }
    }
}