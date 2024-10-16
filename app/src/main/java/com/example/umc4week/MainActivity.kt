package com.example.umc4week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private lateinit var clearButton: Button

    private var isRunning = false
    private var timeInMillis: Long = 0
    private var job: Job? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerTextView = findViewById(R.id.textView)
        startButton = findViewById(R.id.button)
        clearButton = findViewById(R.id.button2)

        startButton.setOnClickListener{
            if(!isRunning){
                startTimer()
            }else{
                pauseTimer()
            }
        }

        clearButton.setOnClickListener{
            clearTimer()
        }


    }

    private fun startTimer(){
        isRunning = true
        startButton.text = "pause"

        job = CoroutineScope(Dispatchers.Main).launch {
            while(isRunning){
                delay(10L)
                timeInMillis +=10
                updateTimerUI()
            }
        }
    }
    private  fun pauseTimer(){
        isRunning=false
        startButton.text="Start"
        job?.cancel()
    }

    private fun clearTimer(){
        timeInMillis=0
        updateTimerUI()
    }

    private fun updateTimerUI(){
        val minutes=(timeInMillis/1000)/60
        val seconds=(timeInMillis/1000)%60
        val milliseconds = (timeInMillis%1000/10)

        val timeFormatted = String.format("%02d:%02d,%02d", minutes, seconds, milliseconds)
        timerTextView.text = timeFormatted
    }
}