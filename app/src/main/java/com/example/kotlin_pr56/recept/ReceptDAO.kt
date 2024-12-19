package com.example.kotlin_pr56.recept

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin_pr56.recept.Recept

@Dao
interface ReceptDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(recept: Recept)
    @Query("SELECT * FROM recepts")
    fun getAllRecepts():List<Recept>
}