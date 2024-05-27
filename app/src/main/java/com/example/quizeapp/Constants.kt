package com.example.quizeapp

object Constants{
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWER: String = "correct_answer"


    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Which Ayurvedic Plant is this?",
            R.drawable.brahmi_plant,
            "Ananas",
            "Babool",
            "Brahmi",
            "Dhaniya",
            3
        )
        questionList.add(que1)

        val que2 = Question(
            2,
            "Where can this ayurvedic plant be found?",
            R.drawable.nagarmotha_plant,
            "Madya Pradesh",
            "Jharkhand",
            "Maharashtra",
            "Arunachal Pradesh",
            1
        )
        questionList.add(que2)

        val que3 = Question(
            3,
            "What is the use of this ayurvedic plant?",
            R.drawable.punarnava_plant,
            "treatment of skin",
            " treatment of renal problems and urinary tract infections",
            "treatment of hairs",
            "treatment of muscels",
            2
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "Where can this ayurvedic plant be found?",
            R.drawable.agarkasth_plant,
            "Madya Pradesh",
            "Jharkhand",
            "Maharashtra",
            "Assam",
            4
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "Which ayurvedic plant is this?",
            R.drawable.ankol_plant,
            "tulsi",
            "virdhadaru",
            "ankol",
            "shilparni",
            3
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "Which ayurvedic plant is this?",
            R.drawable.nagarmotha_plant,
            "nagarmotha",
            "chirchita",
            "elaichi",
            "Akarkara",
            1
        )
        questionList.add(que6)

        val que7 = Question(
            2,
            "Where can this ayurvedic plant be found?",
            R.drawable.malakangini_plant,
            "Odisha",
            "Hemachal Pradesh",
            "Butan",
            "Tibet",
            1
        )
        questionList.add(que7)

        val que8 = Question(
            8,
            "which ayurvedic plant is this?",
            R.drawable.shatavri_plant,
            "gokshura",
            "shatavri",
            "mokshura",
            "ashwaganda",
            2
        )
        questionList.add(que8)

        val que9 = Question(
            9,
            "Which ayurvedic plant is this?",
            R.drawable.yavasa_plant,
            "tulsi",
            "shilajit",
            "neem",
            "yavasa",
            4
        )
        questionList.add(que9)

        val que10 = Question(
            10,
            "What is the use of this ayurvedic plant?",
            R.drawable.shilparni_plant,
            "helps in preventing diarrhoea",
            "helps to manage fever",
            "helps in relieving muscel strain",
            "helps to prevent any skin damage",
            2
        )
        questionList.add(que10)
        return questionList
    }
}