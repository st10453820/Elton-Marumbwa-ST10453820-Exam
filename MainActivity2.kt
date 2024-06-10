package com.example.practicum35

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.concurrent.locks.Condition
@SuppressLint("StaticFieldLeak")
private lateinit var dayInput: EditText
private lateinit var minTempInput: EditText
private lateinit var maxTempInput: EditText
private lateinit var conditionInput: EditText
private val days = mutableListOf<String>()
private val minTemps = mutableListOf<Int>()
private val maxTemps = mutableListOf<Int>()
private val conditions = mutableListOf<String>()

class MainActivity2 : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        dayInput = findViewById(R.id.input_day)
        minTempInput = findViewById(R.id.input_min_temp)
        maxTempInput = findViewById(R.id.input_max_temp)
        conditionInput = findViewById(R.id.input_condition)

        findViewById<Button>(R.id.btn_detailed_view).setOnClickListener {
            try {
                val day = dayInput.text.toString()
                val minTemp = minTempInput.text.toString().toInt()
                val maxTemp = maxTempInput.text.toString().toInt()
                val condition = conditionInput.text.toString()

                days.add(day)
                minTemps.add(minTemp)
                maxTemps.add(maxTemp)
                conditions.add(condition)

                val intent = Intent(this, MainActivity3::class.java)
                intent.putStringArrayListExtra("days", ArrayList(days))
                intent.putIntegerArrayListExtra("minTemps", ArrayList(minTemps))
                intent.putIntegerArrayListExtra("maxTemps", ArrayList(maxTemps))
                intent.putStringArrayListExtra("conditions", ArrayList(conditions))
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btn_clear).setOnClickListener {
            dayInput.text.clear()
            minTempInput.text.clear()
            maxTempInput.text.clear()
            conditionInput.text.clear()

            days.clear()
            minTemps.clear()
            maxTemps.clear()
            conditions.clear()
        }
    }
}











