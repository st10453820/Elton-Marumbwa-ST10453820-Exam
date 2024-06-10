package com.example.practicum35

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.nio.file.DirectoryNotEmptyException

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val detailedInfo = findViewById<TextView>(R.id.detailed_info)
        val averageTemp = findViewById<TextView>(R.id.average_temp)

        val days = intent.getStringArrayListExtra("days") ?: arrayListOf()
        val minTemps = intent.getIntegerArrayListExtra("minTemps") ?: arrayListOf()
        val maxTemps = intent.getIntegerArrayListExtra("maxTemps") ?: arrayListOf()
        val conditions = intent.getStringArrayListExtra("conditions") ?: arrayListOf()

        val details = StringBuilder()
        var totalMinTemp = 0
        var totalMaxTemp = 0

        for (i in days.indices) {
            details.append("Day ${days[i]}: Min Temp: ${minTemps[i]}°C, Max Temp: ${maxTemps[i]}°C, Condition: ${conditions[i]}\n")
            totalMinTemp += minTemps[i]
            totalMaxTemp += maxTemps[i]
        }

        detailedInfo.text = details.toString()

        val avgMinTemp = if (days.isNotEmpty()) totalMinTemp /
                days.size else 0
        val avgMaxTemp = if (days.isNotEmpty()) totalMaxTemp / days.size else 0
        averageTemp.text = "Average Min Temp: $avgMinTemp°C, Average Max Temp: $avgMaxTemp°C"

        findViewById<Button>(R.id.btn_back_to_main).setOnClickListener {
            finish()
        }
    }
}

