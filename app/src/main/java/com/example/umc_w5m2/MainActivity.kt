package com.example.umc_w5m2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private var memoContent: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // XML 레이아웃 설정

        editText = findViewById(R.id.editTextMemo) // EditText 초기화
        val btnNext: Button = findViewById(R.id.btnNext) // 다음 화면 버튼 초기화

        btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity, ViewActivity::class.java)
            intent.putExtra("memoContent", editText.text.toString())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (!memoContent.isNullOrEmpty()) {
            editText.setText(memoContent) // 전역 변수에 저장된 내용 불러오기
        }
    }

    override fun onPause() {
        super.onPause()
        memoContent = editText.text.toString() // 현재 메모 내용을 저장
    }

    override fun onRestart() {
        super.onRestart()

        AlertDialog.Builder(this)
            .setMessage("다시 작성하시겠습니까?")
            .setPositiveButton("예") { dialog, _ ->
                // "예"를 선택하면 내용을 유지하고 다이얼로그 닫기
                dialog.dismiss()
            }
            .setNegativeButton("아니오") { dialog, _ ->
                // "아니오"를 선택하면 onPause에서 저장했던 memoContent 변수를 비우기
                memoContent = ""
                dialog.dismiss()
            }
            .show()
    }

}