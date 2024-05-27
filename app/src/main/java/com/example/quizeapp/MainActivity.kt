package com.example.quizeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {

    lateinit var etName: AppCompatEditText
    lateinit var btnStart: Button
    lateinit var sharedPreferences: SharedPreferences
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE)

        etName = findViewById(R.id.etName)
        btnStart = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            val UserName = etName.text.toString()

            if(UserName.isEmpty()){
                Toast.makeText(this@MainActivity,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this@MainActivity,QuizeQuestionsActivity::class.java)
                SavedPreferences(UserName)
                startActivity(intent)
                finish()
            }
        }
    }

    fun SavedPreferences(User: String){
        sharedPreferences.edit().putString(Constants.USER_NAME,User).apply()
    }
}