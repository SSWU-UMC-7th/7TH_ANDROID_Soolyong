package com.example.umc_w1m1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 행복 아이콘을 클릭했을 때 NextActivity로 이동
        val happyIcon: ImageView = findViewById(R.id.happy_icon)
        happyIcon.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent) // 인텐트를 통해 화면 전환
        }

        // 들뜬 아이콘을 클릭했을 때 NextActivity로 이동
        val excitedIcon: ImageView = findViewById(R.id.excited_icon)
        excitedIcon.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        // 평범 아이콘을 클릭했을 때 NextActivity로 이동
        val commonIcon: ImageView = findViewById(R.id.common_icon)
        commonIcon.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        // 불안 아이콘을 클릭했을 때 NextActivity로 이동
        val nervousIcon: ImageView = findViewById(R.id.nervous_icon)
        nervousIcon.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        // 화남 아이콘을 클릭했을 때 NextActivity로 이동
        val madIcon: ImageView = findViewById(R.id.mad_icon)
        madIcon.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }
    }
}
