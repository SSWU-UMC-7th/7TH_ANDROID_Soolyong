package com.example.umc_w2m1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BottomNavigationView 설정
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // 첫 화면에 보여줄 프래그먼트 설정 (홈 화면으로 지정)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
        }

        // BottomNavigationView 아이템 클릭 리스너 설정
        bottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.navigation_home -> selectedFragment = HomeFragment()
                R.id.navigation_write -> selectedFragment = WriteFragment()
                R.id.navigation_calender -> selectedFragment = CalenderFragment()
                R.id.navigation_profile -> selectedFragment = ProfileFragment()
            }

            // 프래그먼트 전환 시 애니메이션 적용
            if (selectedFragment != null) {
                val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                transaction.replace(R.id.fragment_container, selectedFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }

            true
        }
    }
}