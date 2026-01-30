package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)
        val textView = findViewById<TextView>(R.id.textView)
        var count = 0

        button.setOnClickListener {
            count += 1
            textView.text = count.toString()
            Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            if (count >= 100) {
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.setOnClickListener {
                        count += 2
                        textView.text = count.toString()
                    }
                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}