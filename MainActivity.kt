package com.example.practicum35

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnClick= findViewById<Button>(R.id.btnnext)
        btnClick.setOnClickListener{
            val Intent= Intent(this,MainActivity2::class.java)
            startActivity(Intent)

            findViewById<Button>(R.id.exitButton).setOnClickListener{
                finish()

            }
        }
    }
}