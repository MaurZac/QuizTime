package com.example.quiztime.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.quiztime.Domain.QuestionModel
import com.example.quiztime.R
import com.example.quiztime.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        binding.apply {
            singleBtn.setOnClickListener{
                val intent = Intent(this@MainActivity,QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }

            bottomMenu.setItemSelected(R.id.home)
            bottomMenu.setOnItemSelectedListener {
                if(it == R.id.Board){
                    startActivity((Intent(this@MainActivity,LeaderActivity::class.java)))
                }
            }

        }
    }
    //ejemplo de preguntas, proxima conexion de api service.
    private  fun questionList(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                id = 1,
                question = "¿Cuál es el planeta más grande del Sistema Solar?",
                answer_1 = "Tierra",
                answer_2 = "Saturno",
                answer_3 = "Júpiter",
                answer_4 = "Neptuno",
                correctAnswer = "c",
                score = 8,
                picPath = "q_1",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 2,
                question = "¿Qué gas es esencial para la respiración humana?",
                answer_1 = "Dióxido de Carbono",
                answer_2 = "Nitrógeno",
                answer_3 = "Oxígeno",
                answer_4 = "Hidrógeno",
                correctAnswer = "c",
                score = 5,
                picPath = "q_2",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 3,
                question = "¿En qué año se lanzó la primera consola PlayStation?",
                answer_1 = "1994",
                answer_2 = "1996",
                answer_3 = "1998",
                answer_4 = "2000",
                correctAnswer = "a",
                score = 7,
                picPath = "q_3",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 4,
                question = "¿Qué inventor es conocido por inventar la bombilla eléctrica?",
                answer_1 = "Nikola Tesla",
                answer_2 = "Thomas Edison",
                answer_3 = "Alexander Graham Bell",
                answer_4 = "James Watt",
                correctAnswer = "b",
                score = 6,
                picPath = "q_4",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 5,
                question = "¿Qué país es el más grande del mundo en términos de superficie?",
                answer_1 = "Canadá",
                answer_2 = "Estados Unidos",
                answer_3 = "China",
                answer_4 = "Rusia",
                correctAnswer = "d",
                score = 9,
                picPath = "q_5",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 6,
                question = "¿Cuál es la capital de Australia?",
                answer_1 = "Sídney",
                answer_2 = "Melbourne",
                answer_3 = "Canberra",
                answer_4 = "Brisbane",
                correctAnswer = "c",
                score = 7,
                picPath = "q_6",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 7,
                question = "¿Quién pintó la Mona Lisa?",
                answer_1 = "Vincent van Gogh",
                answer_2 = "Leonardo da Vinci",
                answer_3 = "Pablo Picasso",
                answer_4 = "Claude Monet",
                correctAnswer = "b",
                score = 5,
                picPath = "q_7",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 8,
                question = "¿En qué continente se encuentra el desierto del Sahara?",
                answer_1 = "Asia",
                answer_2 = "África",
                answer_3 = "Australia",
                answer_4 = "América del Sur",
                correctAnswer = "b",
                score = 6,
                picPath = "q_8",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 9,
                question = "¿Cuál es el animal terrestre más rápido del mundo?",
                answer_1 = "León",
                answer_2 = "Guepardo",
                answer_3 = "Tigre",
                answer_4 = "Pantera",
                correctAnswer = "b",
                score = 8,
                picPath = "q_9",
                clickedAnswer = null
            )
        )

        question.add(
            QuestionModel(
                id = 1,
                question = "Cual oceano tiene mayor profundidad?",
                answer_1 = "Oceano Pacifico",
                answer_2 = "Oceano Atlantico",
                answer_3 = "Oceano Indico",
                answer_4 = "Oceano Suroeste",
                correctAnswer = "d",
                score = 5,
                picPath = "q_10",
                clickedAnswer = null
            )
        )
        return question
    }
}