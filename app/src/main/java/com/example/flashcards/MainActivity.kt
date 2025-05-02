package com.example.Flashcards
// ... rest of your MainActivity code

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.flashcards.R
import com.example.flashcards.ResultsActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startQuizButton: Button = findViewById(R.id.start) // Assuming this is your button's ID

        startQuizButton.setOnClickListener {
            val intent = Intent(this, MainActivity ::class.java) // Corrected Intent creation
            startActivity(intent) // Added to start the new Activity
        }
    }
}
