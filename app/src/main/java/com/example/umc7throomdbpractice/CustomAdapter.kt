package com.example.umc7throomdbpractice

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.umc7throomdbpractice.databinding.ItemLayoutBinding

class CustomAdapter(val list:ArrayList<Profile>,context: Context): BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int =list.size

    override fun getItem(position: Int): Any =list[position]

    override fun getItemId(position: Int): Long =position.toLong()

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemLayoutBinding

        if (convertView == null) {
            binding = ItemLayoutBinding.inflate(inflater, parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ItemLayoutBinding
        }

        val currentItem = list[position]
        binding.text1.text = currentItem.name
        binding.text2.text = currentItem.age

        return binding.root
    }

}