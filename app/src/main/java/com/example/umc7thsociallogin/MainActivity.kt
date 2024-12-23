package com.example.umc7thsociallogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc7thsociallogin.databinding.ActivityMainBinding
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.user.UserApiClient

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 로그인 버튼 클릭 이벤트
        binding.btnKakaoLogin.setOnClickListener {
            if (AuthApiClient.instance.hasToken()) {
                loginWithKakao()
            } else {
                loginWithKakao()
            }
        }
    }

    private fun loginWithKakao() {
        UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
            if (error != null) {
                // 로그인 실패
                error.printStackTrace()
            } else if (token != null) {
                // 로그인 성공
                UserApiClient.instance.me { user, error ->
                    if (user != null) {
                        val intent = Intent(this, HomeActivity::class.java).apply {
                            putExtra("nickname", user.kakaoAccount?.profile?.nickname)
                            putExtra("email", user.kakaoAccount?.email)
                            putExtra("profileImageUrl", user.kakaoAccount?.profile?.thumbnailImageUrl)
                        }
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}