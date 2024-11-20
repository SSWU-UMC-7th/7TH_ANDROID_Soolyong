package com.example.umc7throomdbpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.umc7throomdbpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var list =ArrayList<Profile>()
    lateinit var customAdapter: CustomAdapter
    lateinit var db: ProfileDatabase
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = ProfileDatabase.getInstance(this)!!

        Thread {
            val savedProfiles = db.profileDao().getAll()
            if (savedProfiles.isNotEmpty()) {
                list.addAll(savedProfiles)
            }
        }.start()

        binding.button.setOnClickListener {
            Thread {
                list.add(Profile("베어", "24", "0000"))
                db.profileDao().insert(Profile("베어", "24", "0000"))

                runOnUiThread {
                    customAdapter.notifyDataSetChanged()
                }

                val list = db.profileDao().getAll()
                Log.d("Primary", list[list.size-1].id.toString())
            }.start()
        }

        customAdapter = CustomAdapter(list,this)

        binding.mainProfileLv.adapter = customAdapter
    }
}