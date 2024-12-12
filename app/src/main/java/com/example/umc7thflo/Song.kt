package com.example.umc7thflo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SongTable")
data class Song(
    val title : String = "",  //제목
    val singer : String = "",  //가수
    var second: Int = 0,  //재생 시간
    var playTime: Int = 0,  //현재 재생 시간
    var isPlaying: Boolean = false,  //재생 되고 있는지
    var music: String = "",  //어떤 음악이 재생되고 있는지
    var coverImg: Int? = null,
    var isLike: Boolean = false
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}