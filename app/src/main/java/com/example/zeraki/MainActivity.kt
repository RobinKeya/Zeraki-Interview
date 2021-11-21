package com.example.zeraki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
public var position = 0
class MainActivity : AppCompatActivity() {
    public var position = 0
    private lateinit var color: TextView
    private lateinit var colorName: TextView
    private lateinit var btnStart: Button
    private lateinit var btnNext: Button
    private lateinit var btnPrevious: Button
    private lateinit var btnExercise : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         color = findViewById(R.id.color)
         colorName = findViewById(R.id.color_name)
         btnStart = findViewById(R.id.start_btn)
         btnNext = findViewById(R.id.next_btn)
         btnPrevious = findViewById(R.id.previous_btn)
         btnExercise = findViewById(R.id.exercise_btn)


        btnStart.setOnClickListener{

            color.setBackgroundResource(ColorData.colors[position])
            colorName.text = ColorData.color_names[position]
            color.visibility=View.VISIBLE
            colorName.visibility = View.VISIBLE
            it.visibility = View.GONE
            btnNext.visibility=View.VISIBLE
        }
        btnNext.setOnClickListener {
            ++position
            if(position>=ColorData.color_names.lastIndex){
                it.visibility = View.GONE
                showExerciseButton()
            }else{
                color.setBackgroundResource(ColorData.colors[position])
                colorName.text = ColorData.color_names.get(position)

            }

            showPreviousButton()

        }
        btnPrevious.setOnClickListener {
            --position
            if(position==-1){
                btnPrevious.visibility = View.GONE
            }else{
                showPreviousButton()
            }


        }
        btnExercise.setOnClickListener {
            //to exercise activity
            startActivity(Intent(this, Exercise::class.java))
        }
    }
    private fun showPreviousButton(){
            btnPrevious.visibility = View.VISIBLE
            color.setBackgroundResource(ColorData.colors[position])
            colorName.text = ColorData.color_names.get(position)

    }
    private fun showExerciseButton(){
            btnExercise.visibility = View.VISIBLE
    }
}