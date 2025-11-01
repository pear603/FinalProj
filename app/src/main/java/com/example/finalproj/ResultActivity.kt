package com.example.finalproj

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val selectedSign = intent.getStringExtra("selectedSign")
        val resultText = findViewById<TextView>(R.id.resultText)

        // Example: Show zodiac and a sample horoscope
        val horoscope = getHoroscopeForSign(selectedSign)
        resultText.text = "Your Zodiac: $selectedSign\n\n$horoscope"
    }

    private fun getHoroscopeForSign(sign: String?): String {
        return when(sign) {
            "Aries" -> "Today is a good day to try something new."
            "Taurus" -> "Focus on your finances today."
            // Add remaining 10 zodiac horoscopes here
            else -> "Enjoy your day!"
        }
    }
}