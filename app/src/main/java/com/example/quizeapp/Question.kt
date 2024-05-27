package com.example.quizeapp

data class Question(
    val id:Int,
    val Question:String,
    val image:Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val CorrectOption:Int
)