package com.example.finalproj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class ResultActivity : AppCompatActivity() {

    private val BASE_URL = "https://horoscope-app-api.vercel.app/api/v1/get-horoscope"

    private lateinit var resultTitle: TextView
    private lateinit var resultText: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultTitle = findViewById(R.id.resultTitle)
        resultText = findViewById(R.id.resultText)
        backButton = findViewById(R.id.backButton)

        val sign = intent.getStringExtra("selectedSign")

        if (sign.isNullOrEmpty()) {
            resultText.text = "Please select a zodiac sign."
            return
        }

        resultTitle.text = "Your Horoscope for $sign"
        resultText.text = "Loading your horoscope..."

        lifecycleScope.launch {
            val result = fetchHoroscope(sign)
            resultText.text = result
            if (result.startsWith("Error")) {
                Toast.makeText(this@ResultActivity, result, Toast.LENGTH_LONG).show()
            }
        }

        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            })
            finish()
        }
    }

    private suspend fun fetchHoroscope(sign: String): String = withContext(Dispatchers.IO) {
        try {
            val client = OkHttpClient()
            // this API supports a format like:
            // https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=aries&day=today
            val url = "$BASE_URL/daily?sign=${sign.lowercase()}&day=today"
            val request = Request.Builder().url(url).build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    return@use "Error: ${response.code} - ${response.message}"
                }

                val body = response.body?.string() ?: return@use "Empty response"
                val json = JSONObject(body)

                // API returns something like: {"data": {"horoscope_data": "text here"}}
                val data = json.optJSONObject("data")
                data?.optString("horoscope_data") ?: "No horoscope found"
            }
        } catch (e: Exception) {
            "Error: ${e.message ?: "Unknown error occurred"}"
        }
    }
}
