package com.example.quizeapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    var UserName : String? = null
    lateinit var sharedPreferences: SharedPreferences
    lateinit var txtUser: TextView
    lateinit var txtscore: TextView
    lateinit var btnFinish: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE)
        txtUser = findViewById(R.id.txtUser)
        txtscore = findViewById(R.id.txtscore)
        btnFinish = findViewById(R.id.btnFinish)

    UserName = sharedPreferences.getString(Constants.USER_NAME,"Username")
        txtUser.text = UserName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        txtscore.text = "Your score is $correctAnswer out of $totalQuestions"

        btnFinish.setOnClickListener {
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}