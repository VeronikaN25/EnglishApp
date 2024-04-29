package com.example.magicenglish.components.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Verb(
    @PrimaryKey(autoGenerate = true)
    val id : Int=0,
    val infinitive: String,
    val past: String,
    val pastParticiple: String,
)
