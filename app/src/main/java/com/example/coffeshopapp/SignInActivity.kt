package com.example.coffeshopapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeshopapp.models.testUser1

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun onLogin(view: View) {
        val textViewLogin: TextView = findViewById<TextView>(R.id.si_editText)
        val textViewPassword: TextView = findViewById<TextView>(R.id.si_editTextTextPassword)
        val textLogin: String = textViewLogin.text.toString()
        val textPassword: String = textViewPassword.text.toString()

        //test
        if (textLogin == testUser1.username && textPassword == testUser1.password) {
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        } else {
            val myMessage = Toast.makeText(this, "Error!", Toast.LENGTH_SHORT)
            myMessage.show()
        }
    }
}