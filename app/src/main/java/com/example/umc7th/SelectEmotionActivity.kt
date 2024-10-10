package com.example.umc7th

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th.databinding.ActivitySelectEmotionBinding

class SelectEmotionActivity : AppCompatActivity() {

    lateinit var binding: ActivitySelectEmotionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectEmotionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectHappyIv.setOnClickListener {
            val intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
        }
    }
}