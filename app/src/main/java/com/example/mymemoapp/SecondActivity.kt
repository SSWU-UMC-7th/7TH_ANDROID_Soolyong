package com.example.mymemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymemoapp.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val userText = intent.getStringExtra("memo") // MainActivity로부터 텍스트를 가져옴

        if (userText != null) {
            binding.secondWriteEt.text = userText // TextView에 텍스트 표시
        }
    }
}