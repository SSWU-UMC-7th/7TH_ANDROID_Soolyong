package com.example.week5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var editTextContent: String? = null  // 전역 변수로 메모 내용을 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText = findViewById<EditText>(R.id.editText)
        val button= findViewById<Button>(R.id.button01)
        //각 아이디 설정 해줘야됨

        //버튼 클릭했을 때 확인 화면으로 넘어가기
        button.setOnClickListener{
            editTextContent= editText.text.toString()
            //확인 화면에서 보여줄 내용을 editTextContent에 저장

            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("memoContent", editTextContent)  // 메모 내용 전달
            startActivity(intent)  // ContentActivity로 이동


        }


    }

    override fun onResume() {
        super.onResume()
        val editText = findViewById<EditText>(R.id.editText)

        // onPause에서 저장된 내용이 있다면 EditText에 복원
        editTextContent?.let {
            editText.setText(it)
        }
    }

    override fun onPause() {
        super.onPause()
        val editText = findViewById<EditText>(R.id.editText)

        // 현재 입력된 내용을 전역 변수에 저장
        editTextContent = editText.text.toString()
    }

    override fun onRestart() {
        super.onRestart()

        // AlertDialog로 다시 작성 여부 확인
        val builder = AlertDialog.Builder(this)
        builder.setMessage("다시 작성하시겠습니까?")
            .setPositiveButton("네") { dialog, _ ->
                // "네"를 누르면 아무 작업도 하지 않음 (내용 유지)
                dialog.dismiss()
            }
            .setNegativeButton("아니요") { dialog, _ ->
                // "아니요"를 누르면 onPause에서 저장했던 변수 비우기
                editTextContent = null
                findViewById<EditText>(R.id.editText).setText("")
                Log.e("onRestart", "Content cleared")
                dialog.dismiss()
            }
        builder.create().show()
    }
}
