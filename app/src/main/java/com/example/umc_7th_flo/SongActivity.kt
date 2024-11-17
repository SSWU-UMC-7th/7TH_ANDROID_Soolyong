package com.example.umc_7th_flo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_7th_flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity(){
    lateinit var binding : ActivitySongBinding
    private var musicTitle: String? = null
    private var musicSinger: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        musicTitle = intent.getStringExtra("EXTRA_MUSIC_TITLE")
//        musicSinger = intent.getStringExtra("EXTRA_MUSIC_SINGER")
//
//        // Find the TextViews by their IDs
//        binding.songMusicTitleTv.text = musicTitle
//        binding.songSingerNameTv.text = musicSinger

        binding.songDownIb.setOnClickListener {
//            val resultIntent = Intent()
//            resultIntent.putExtra("RETURNED_MUSIC_TITLE", musicTitle)
//            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }
        if (intent.hasExtra("title") && intent.hasExtra("singer")) {
            binding.songMusicTitleTv.text = intent.getStringExtra("title")
            binding.songSingerNameTv.text = intent.getStringExtra("singer")
        }
    }

    fun setPlayerStatus(isPlaying : Boolean) {
        if(isPlaying) {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
        else {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }
}