package com.example.magicenglish.components.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.magicenglish.components.entity.Verb

@Dao
interface VerbDao {
    @Query("select * from verb")
    fun getAllVerbs(): List<Verb>
}