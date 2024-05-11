package com.example.magicenglish.vocabulary_trainer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
data class LocalWord(
    @PrimaryKey val value: String,
)
