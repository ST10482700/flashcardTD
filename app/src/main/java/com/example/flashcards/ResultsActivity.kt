package com.example.flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val score = intent.getIntExtra("SCORE", 0)
        val questions = intent.getByteArrayExtra("QUESTIONS")!!
        val answers = intent.getBooleanArrayExtra("ANSWERS")!!
        val userAnswers = intent.getBooleanArrayExtra("USER_ANSWERS")!!

        val resultText = findViewById<TextView>(R.id.resultText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewButton = findViewById<Button>(R.id.reviewButton) // Corrected ID
        val exitButton = findViewById<Button>(R.id.exitButton)   // Corrected ID

        resultText.text = "You got $score out of ${questions.size}" // Improved string formatting
        feedbackText.text = if (score >= 3) "Great job!" else "Keep practicing!" // Corrected spelling

        reviewButton.setOnClickListener {
            val intent = Intent(this, activityResultRegistry ::class.java) //n Corrected Intent instantiation
            intent.putExtra("QUESTIONS", questions) // Corrected key name to plural
            intent.putExtra("ANSWERS", answers)
            startActivity(intent)
        }
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}