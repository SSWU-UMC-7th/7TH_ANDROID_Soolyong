package com.example.umc7thsociallogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.umc7thsociallogin.databinding.ActivityHomeBinding
import com.kakao.sdk.user.UserApiClient

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전달받은 사용자 데이터
        val nickname = intent.getStringExtra("nickname")
        val email = intent.getStringExtra("email")
        val profileImageUrl = intent.getStringExtra("profileImageUrl")

        // 뷰에 데이터 바인딩
        binding.txtNickname.text = nickname
        binding.txtEmail.text = email
        Glide.with(this).load(profileImageUrl).into(binding.imgProfile)

        // 로그아웃 버튼 클릭 이벤트
        binding.btnLogout.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error == null) {
                    // 로그아웃 성공
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}