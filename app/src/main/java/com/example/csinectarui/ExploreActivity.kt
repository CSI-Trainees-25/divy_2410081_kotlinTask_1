package com.example.csinectarui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView

class ExploreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explore)

        val beveragesCard = findViewById<Button>(R.id.beveragescard)
        beveragesCard.setOnClickListener {
            val intent = Intent(this, BeveragesActivity::class.java)
            startActivity(intent)
        }
    }
}
