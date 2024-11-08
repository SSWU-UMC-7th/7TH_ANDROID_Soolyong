package com.example.week6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeliveryAdapter (val deliverylist: ArrayList<delivery>): RecyclerView.Adapter<DeliveryAdapter.CustomViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryAdapter.CustomViewHolder {
        // 플러그 될 화면과 연결해주는 함수
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return CustomViewHolder(view)
        //context란 액티비티에서 담고 있는 모든 정보(연결한 액티비티에서 담고 있는 정보들)
    }

    override fun onBindViewHolder(holder: DeliveryAdapter.CustomViewHolder, position: Int) {
        holder.shopimge.setImageResource(deliverylist.get(position).shopimage)
        holder.shopnaming.text = deliverylist.get(position).shopnaming
        holder.stargrade.text = deliverylist.get(position).stargrade
        holder.timing.text = deliverylist.get(position).timing
        //stargrade와 timing은 Int로 지정해놨기때문에 .toString()으로 하지않으면 오류가 남, 그렇지만 숫자와 문자가 같이 있어서 데이터타입을 String으로 바꿈

    }

    override fun getItemCount(): Int {
        // 출력할 리스트의 갯수를 적어줘야함
        return deliverylist.size

    }

    class CustomViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
        val shopimge = itemView.findViewById<ImageView>(R.id.image01) //가게 이미지
        val shopnaming = itemView.findViewById<TextView>(R.id.tv_shopname) //가게 이름
        val stargrade = itemView.findViewById<TextView>(R.id.tv_star) // 별점
        val timing = itemView.findViewById<TextView>(R.id.tv_time) // 도보 시간


    }

}