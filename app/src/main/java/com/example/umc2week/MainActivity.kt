package com.example.umc2week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 초기 Fragment 설정 (예: HomeFragment를 기본으로 띄우기)
        replaceFragment(HomeFragment())

        // BottomNavigationView 아이템 클릭 리스너 설정
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment()) // 홈 화면으로 전환
                    true
                }

                R.id.nav_calendar -> {
                    replaceFragment(CalendarFragment()) // 캘린더 화면으로 전환
                    true
                }

                R.id.nav_pencil -> {
                    replaceFragment(PencilFragment()) // 펜슬 화면으로 전환
                    true
                }

                R.id.nav_user -> {
                    // UserFragment가 아닌 UserActivity로 전환
                    val intent = Intent(this, UserActivity::class.java)
                    startActivity(intent)

                    // Activity 전환 시 애니메이션 효과 적용
                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left)
                    true
                }

                else -> false
            }
        }
    }

    // Fragment 교체 및 애니메이션 적용 함수
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        // 슬라이드 애니메이션 적용
        transaction.setCustomAnimations(
            R.anim.slide_right,  // 들어오는 프래그먼트 애니메이션
            R.anim.slide_left    // 나가는 프래그먼트 애니메이션
        )

        // 프래그먼트 교체
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}
