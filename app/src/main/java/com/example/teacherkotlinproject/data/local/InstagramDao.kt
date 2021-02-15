package com.example.teacherkotlinproject.data.local

import androidx.room.*
import com.example.teacherkotlinproject.data.model.Publication

//CRUD - CREATE READ UPDATE DELETE
//    @Insert - Post
//    @Update - Put
//    @Query - Произвольный запрос
//    @Delete - Delete
@Dao
interface InstagramDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPublications(data: List<Publication>?)

    @Query("SELECT * FROM publications")
    fun getPublications(): List<Publication>

}