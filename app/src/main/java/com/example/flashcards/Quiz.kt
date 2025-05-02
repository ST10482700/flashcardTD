package com.example.flashcards

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Quiz : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the president of South Africa in 1994.",
        "The Great Wall of China is in Japan.",
        "World War II ended in 1945.",
        "Julius Caesar was a Roman Emperor.",
        "The Berlin Wall fell in 1989."
    )
    private val answers = arrayOf(true, false, true, false, true)
    private var currentQuestion = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz) // Corrected layout file name

        // Initialize views using findViewById
        questionText = findViewById(R.id.questionText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        resultText = findViewById(R.id.resultText)

        showQuestion() // Display the first question

        // Set click listeners for the buttons
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
    }

    private fun showQuestion() {
        if (currentQuestion < questions.size) {
            // Display the current question
            questionText.text = "${currentQuestion + 1}. ${questions[currentQuestion]}"
            resultText.text = "" // Clear the result text from the previous answer
        } else {
            // Quiz is finished, display the final score
            questionText.text = "Quiz Finished!"
            trueButton.isEnabled = false // Disable buttons after the quiz
            falseButton.isEnabled = false
            resultText.text = "You got $score out of ${questions.size}.\n" +
                    if (score >= 3) "Great job!" else "Keep practicing!"
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        // Check if the user's answer is correct
        if (userAnswer == answers[currentQuestion]) {
            resultText.text = "Correct!"
            score++ // Increment the score if the answer is correct
        } else {
            resultText.text = "Incorrect!"
        }
        currentQuestion++ // Move to the next question
        showQuestion() // Display the next question or the final result
    }
}