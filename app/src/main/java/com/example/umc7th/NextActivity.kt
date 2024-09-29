package com.example.umc7th

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7th.databinding.ActivityNextBinding

class NextActivity: AppCompatActivity() {
    lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}