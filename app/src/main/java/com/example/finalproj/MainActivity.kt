package com.example.finalproj

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var selectedSign: String? = null
    private lateinit var zodiacButtons: List<ImageButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find all zodiac buttons
        val btnAries = findViewById<ImageButton>(R.id.btnAries)
        val btnTaurus = findViewById<ImageButton>(R.id.btnTaurus)
        val btnGemini = findViewById<ImageButton>(R.id.btnGemini)
        val btnCancer = findViewById<ImageButton>(R.id.btnCancer)
        val btnLeo = findViewById<ImageButton>(R.id.btnLeo)
        val btnVirgo = findViewById<ImageButton>(R.id.btnVirgo)
        val btnLibra = findViewById<ImageButton>(R.id.btnLibra)
        val btnScorpio = findViewById<ImageButton>(R.id.btnScorpio)
        val btnSagittarius = findViewById<ImageButton>(R.id.btnSagittarius)
        val btnCapricornus = findViewById<ImageButton>(R.id.btnCapricornus)
        val btnAquarius = findViewById<ImageButton>(R.id.btnAquarius)
        val btnPisces = findViewById<ImageButton>(R.id.btnPisces)

        zodiacButtons = listOf(
            btnAries, btnTaurus, btnGemini, btnCancer, btnLeo, btnVirgo,
            btnLibra, btnScorpio, btnSagittarius, btnCapricornus, btnAquarius, btnPisces
        )

        // Map of buttons to their signs
        val zodiacMap = mapOf(
            btnAries to "Aries",
            btnTaurus to "Taurus",
            btnGemini to "Gemini",
            btnCancer to "Cancer",
            btnLeo to "Leo",
            btnVirgo to "Virgo",
            btnLibra to "Libra",
            btnScorpio to "Scorpio",
            btnSagittarius to "Sagittarius",
            btnCapricornus to "Capricornus",
            btnAquarius to "Aquarius",
            btnPisces to "Pisces"
        )

        // Handle selection state
        for ((button, sign) in zodiacMap) {
            button.setOnClickListener {
                clearSelections()
                button.isSelected = true
                selectedSign = sign
            }
        }

        // Submit button
        val submitBtn = findViewById<Button>(R.id.submitButton)
        submitBtn.setOnClickListener {
            if (selectedSign != null) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("selectedSign", selectedSign)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a zodiac sign", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearSelections() {
        for (button in zodiacButtons) {
            button.isSelected = false
        }
    }
}
