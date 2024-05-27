package com.example.quizeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizeQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var progressBar: ProgressBar
    lateinit var txtprogress: TextView
    lateinit var txtQuestion: TextView
    lateinit var imgplant: ImageView
    lateinit var txtOptionOne:TextView
    lateinit var txtOptionTwo:TextView
    lateinit var txtOptionThree:TextView
    lateinit var txtOptionFour:TextView
    lateinit var btnSubmit: Button

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quize_questions)

        progressBar = findViewById(R.id.progressBar)
        txtprogress = findViewById(R.id.txtprogress)
        txtQuestion = findViewById(R.id.txtQuestion)
        imgplant = findViewById(R.id.imgplant)
        txtOptionOne = findViewById(R.id.txtOptionOne)
        txtOptionTwo = findViewById(R.id.txtOptionTwo)
        txtOptionThree = findViewById(R.id.txtOptionThree)
        txtOptionFour = findViewById(R.id.txtOptionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        txtOptionOne.setOnClickListener(this)
        txtOptionTwo.setOnClickListener(this)
        txtOptionThree.setOnClickListener(this)
        txtOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestion()

    }
    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        txtprogress.text = "$mCurrentPosition/${progressBar.max}"

        txtQuestion.text = question!!.Question
        imgplant.setImageResource(question.image)

        txtOptionOne.text = question.optionOne
        txtOptionTwo.text = question.optionTwo
        txtOptionThree.text = question.optionThree
        txtOptionFour.text = question.optionFour

        btnSubmit.text = "SUBMIT"
    }


    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, txtOptionOne)
        options.add(1, txtOptionTwo)
        options.add(2, txtOptionThree)
        options.add(3, txtOptionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizeQuestionsActivity,
                R.drawable.default_option_border_bg
            )

        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.txtOptionOne -> {
                selectedOptionView(txtOptionOne, 1)
            }
            R.id.txtOptionTwo -> {
                selectedOptionView(txtOptionTwo, 2)
            }
            R.id.txtOptionThree -> {
                selectedOptionView(txtOptionThree, 3)
            }
            R.id.txtOptionFour -> {
                selectedOptionView(txtOptionFour, 4)
            }
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this@QuizeQuestionsActivity, ResultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.CorrectOption != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.CorrectOption, R.drawable.correct_option_border_bg)
                    if (mCurrentPosition == mQuestionList?.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1 ->{
                txtOptionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
                txtOptionOne.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            2 ->{
                txtOptionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
                txtOptionTwo.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            3 ->{
                txtOptionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
                txtOptionThree.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            4 ->{
                txtOptionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
                txtOptionFour.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizeQuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }
}


