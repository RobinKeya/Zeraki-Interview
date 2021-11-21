package com.example.zeraki

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Exercise : AppCompatActivity() {
    private var mediaPlayer : MediaPlayer? = null
    private lateinit var lessons :Button
    private lateinit var submit :Button
    private lateinit var exercise_color: TextView
    private lateinit var error: TextView
    private lateinit var answer: EditText
    private var position =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        lessons=findViewById(R.id.lessons)
        submit = findViewById(R.id.submit)
        exercise_color = findViewById(R.id.exercise_color)
        answer = findViewById(R.id.answer)
        error = findViewById(R.id.error)
        exercise_color.setBackgroundResource(ColorData.colors[position])

        lessons.setOnClickListener {
            position=0
        startActivity(Intent(this,MainActivity::class.java))
        }
        submit.setOnClickListener {
            if (!answer.text.isEmpty()){
                if (answer.text.toString().uppercase().equals(ColorData.color_names[position])){
                    //playmedia
                        playMedia()
                    //increament the position
                    Toast.makeText(this,"Successful",Toast.LENGTH_SHORT).show()
                    answer.text.clear()
                    position++
                    shownext()
                }else{
                    error.visibility = View.VISIBLE
                    answer.text.clear()
                }
            }else{
                answer.setError("No answer provided")
            }
        }
    }

    private fun shownext() {
        if(position<=ColorData.colors.lastIndex){
            exercise_color.setBackgroundResource(ColorData.colors[position])
        }else{
            position=0
            exercise_color.setBackgroundResource(ColorData.colors[position])
        }

    }

    private fun playMedia() {
        mediaPlayer = MediaPlayer.create(this,R.raw.clap)
       mediaPlayer?.start()
    }
}