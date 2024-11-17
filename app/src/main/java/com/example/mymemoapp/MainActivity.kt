package com.example.mymemoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mymemoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var memo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.memoActiveBtn.setOnClickListener{
            memo = binding.memoWriteEt.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("memo", memo) // 텍스트를 인텐트에 추가
            startActivity(intent) // SecondActivity로 이동
        }
    }

    override fun onRestart() {
        super.onRestart()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("다이얼로그")
            .setMessage("다시 작성하시겠습니까?")
            .setPositiveButton("확인") { dialog, which ->
            }
            .setNegativeButton("취소") { dialog, which ->
                binding.memoWriteEt.setText("")
                memo = ""
            }
        builder.show()
    }

    override fun onResume() {
        super.onResume()
        if (memo.isNotEmpty()) {
            binding.memoWriteEt.setText(memo)
        }
    }

    override fun onPause() {
        super.onPause()
        memo = binding.memoWriteEt.text.toString()
    }

}