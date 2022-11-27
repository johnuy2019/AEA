package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSignIn: Button = findViewById(R.id.btnSignIn)
        val txtUsername: EditText = findViewById(R.id.txtUsername)
        val txtPassword: EditText = findViewById(R.id.txtPassword)

        btnSignIn.setOnClickListener {
            if(txtUsername.getText().toString()=="admin" && txtPassword.getText().toString()=="admin"){
                val intent = Intent(this, BottomNavigation::class.java)
                startActivity(intent)
            }
        }
    }
}