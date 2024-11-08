package com.example.week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvDelivery = findViewById<RecyclerView>(R.id.rv_delivery) // RecyclerView 연결

        val deliverylist = arrayListOf(
            delivery(R.drawable.image01,"이디야커피","평점 : 5.0","도보 10분"),
            delivery(R.drawable.image02,"빽다방","평점 : 4.8","도보 5분"),
            delivery(R.drawable.image03,"고망고","평점 : 4.5","도보 8분"),
            delivery(R.drawable.image04,"와플대학","평점 : 4.5","도보 10분"),
            delivery(R.drawable.image05,"파리바게트","평점 : 4.2","도보 8분")
        )

        rvDelivery.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvDelivery.setHasFixedSize(true)
        rvDelivery.adapter = DeliveryAdapter(deliverylist)
    }
}
