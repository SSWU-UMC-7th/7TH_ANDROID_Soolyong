package com.example.umc7thflo

data class Album(
    var title: String? = "",
    var singer: String? = "",
    var coverImg : Int? = null,
    var songs: ArrayList<Song>? = null  //수록곡
)
