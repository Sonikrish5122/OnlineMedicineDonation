package com.example.OnlineMedicineDonation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.OnlineMedicineDonation.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        //val password = findViewById<TextInputEditText>(R.id.password)
        //val email = findViewById<TextInputEditText>(R.id.email)
        val signup = findViewById<TextView>(R.id.signup)
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            val email = findViewById<TextInputEditText>(R.id.email).text.toString()
            val password = findViewById<TextInputEditText>(R.id.password).text.toString()

            if(email == "admin@123"&& password == "123"){
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Incorrect Password or E-mail id", Toast.LENGTH_SHORT).show()
            }
        }
        signup.setOnClickListener {
            Intent(this, RegistrationActivity::class.java).also(){startActivity(it)}
            signup.movementMethod =
                LinkMovementMethod.getInstance();
        }
        binding.bottomNavigationView.selectedItemId = R.id.bottom_nav_login
        binding.bottomNavigationView.setOnItemSelectedListener { it
            when (it.itemId) {
                R.id.bottom_nav_reg -> {
                    Intent(this, RegistrationActivity::class.java).also{ startActivity(it) }
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}
