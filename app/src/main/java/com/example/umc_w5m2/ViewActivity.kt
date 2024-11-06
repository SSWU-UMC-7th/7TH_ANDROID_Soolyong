package com.example.umc_w5m2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val textView: TextView = findViewById(R.id.textViewMemo)
        val memoContent = intent.getStringExtra("memoContent")
        textView.text = memoContent // 전달받은 메모 내용 표시
    }
}
