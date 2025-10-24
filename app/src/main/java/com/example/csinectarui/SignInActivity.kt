package com.example.csinectarui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    private val userMap = mapOf(
        "divya" to "android123",
        "admin" to "admin123",
        "test" to "test123"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Links to signin.xml

        // You can add your sign-in logic here later

        val userMail=findViewById<EditText>(R.id.user_mail)
        val  userPass=findViewById<EditText>(R.id.user_pass)
        val enterButton = findViewById<Button>(R.id.login_app)

        enterButton.setOnClickListener {
            val username = userMail.text.toString().trim()
            val password = userPass.text.toString().trim()

            enterButton.setOnClickListener {
                val username = userMail.text.toString().trim()
                val password = userPass.text.toString().trim()

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (!userMap.containsKey(username)) {
                    Toast.makeText(this, "Username does not exist", Toast.LENGTH_SHORT).show()
                } else if (userMap[username] != password) {
                    Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, HomeScreenActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    finish()
                }
            }

        }
    }
}


