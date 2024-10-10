package com.example.umc7th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc7th.databinding.FragmentCalBinding

class CalFragment: Fragment() {
    lateinit var binding: FragmentCalBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalBinding.inflate(inflater, container, false)

        return binding.root
    }
}