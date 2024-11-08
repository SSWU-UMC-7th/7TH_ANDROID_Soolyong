package com.example.week5

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        // 메모 내용 받기
        val memoContent = intent.getStringExtra("memoContent")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = memoContent
    }
}