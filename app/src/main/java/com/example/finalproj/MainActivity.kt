package com.example.finalproj

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var selectedSign: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example: Aries and Taurus buttons
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



        btnAries.setOnClickListener {
            selectedSign = "Aries"
        }
        btnTaurus.setOnClickListener {
            selectedSign = "Taurus"
        }
        btnGemini.setOnClickListener {
            selectedSign = "Gemini"
        }
        btnCancer.setOnClickListener {
            selectedSign = "Cancer"
        }
        btnLeo.setOnClickListener {
            selectedSign = "Leo"
        }
        btnVirgo.setOnClickListener {
            selectedSign = "Virgo"
        }
        btnLibra.setOnClickListener {
            selectedSign = "Libra"
        }
        btnScorpio.setOnClickListener {
            selectedSign = "Scorpio"
        }
        btnSagittarius.setOnClickListener {
            selectedSign = "Sagittarius"
        }
        btnCapricornus.setOnClickListener {
            selectedSign = "Capricornus"
        }
        btnAquarius.setOnClickListener {
            selectedSign = "Aquarius"
        }
        btnPisces.setOnClickListener {
            selectedSign = "Pisces"
        }

        val submitBtn = findViewById<Button>(R.id.submitButton)
        submitBtn.setOnClickListener {
            if (selectedSign != null) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("selectedSign", selectedSign)
                startActivity(intent)
            } else {
                // Optional: alert if user didn't select a sign
                android.widget.Toast.makeText(this, "Please select a zodiac sign", android.widget.Toast.LENGTH_SHORT).show()
            }
        }
    }
}