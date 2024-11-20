package com.example.week7

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomMasterTable

@Database(entities = [Profile::class], version = 1)
// entities = [어떤 테이블이 데이터베이스에 들어갈지(array 형식으로))
abstract class ProfileDatabase: RoomDatabase () {
    abstract fun profileDao(): ProfileDao

    companion object {
        private var instance: ProfileDatabase? = null

        @Synchronized
        //동기화 - 실행 순서가 없는 스레드에 순서를 만들어줌
        fun getInstance(context: Context): ProfileDatabase? {
            if (instance == null) {
                //두개의 스레드가 동시에 접근할 수 없게끔 방지해줌
                synchronized(ProfileDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProfileDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance
        }
    }
}