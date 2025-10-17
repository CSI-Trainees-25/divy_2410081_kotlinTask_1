package com.example.csinectarui
import android.os.Handler
import android.os.Looper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            finish() // Closes the activity
        }, 1000)


    // Link to your XML layout
    }
}