package com.example.csinectarui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome) // Links to welcome.xml

        // Find the button by ID and set click listener
        val startButton = findViewById<Button>(R.id.start_app)

        startButton.setOnClickListener {
            // Create intent to navigate to SignInActivity
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}