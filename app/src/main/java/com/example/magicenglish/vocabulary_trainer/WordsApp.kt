package com.example.magicenglish.vocabulary_trainer

import android.app.Application
import androidx.room.Room

class WordsApp: Application(){
    private val database by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java,"database.db").build()
    }
    val wordRepository by lazy { WordRepository(database) }
}