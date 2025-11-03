package com.example.finalproj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTitle = findViewById<TextView>(R.id.resultTitle)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Get selected sign from MainActivity
        val selectedSign = intent.getStringExtra("selectedSign")

        // Display sign name
        resultTitle.text = "Your Horoscope for $selectedSign"

        // Show dummy horoscope (you can replace this with real API data later)
        val horoscope = when (selectedSign) {
            "Aries" -> "Today is full of new opportunities. Be brave and take the lead!"
            "Taurus" -> "Patience and persistence bring rewards. Stay calm and focused."
            "Gemini" -> "Communication is your strength today — share your thoughts!"
            "Cancer" -> "Emotions run deep; take time to care for yourself and loved ones."
            "Leo" -> "Your charm shines bright! A great day for social and creative energy."
            "Virgo" -> "Organization leads to success. Focus on the details."
            "Libra" -> "Balance is key. Resolve conflicts with fairness and kindness."
            "Scorpio" -> "Your passion drives you. Follow your instincts confidently."
            "Sagittarius" -> "Adventure awaits! Be open to learning something new."
            "Capricornus" -> "Hard work pays off — progress is closer than you think."
            "Aquarius" -> "Innovation sparks today. Don’t be afraid to be different."
            "Pisces" -> "Your intuition guides you well. Trust your dreams and feelings."
            else -> "Please select a zodiac sign."
        }

        resultText.text = horoscope

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // Clear back stack
            startActivity(intent)
            finish() // Optional: close ResultActivity
        }
    }
}
