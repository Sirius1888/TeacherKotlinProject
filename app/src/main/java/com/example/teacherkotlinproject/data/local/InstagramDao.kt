package com.example.teacherkotlinproject.data.local

import androidx.room.*
import com.example.teacherkotlinproject.data.model.Publication

//CRUD - CREATE READ UPDATE DELETE
//    @Insert - Post - Добавление
//    @Update - Put - Изменение
//    @Query - Произвольный запрос
//    @Delete - Delete - Удаление
@Dao
interface InstagramDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPublications(data: List<Publication>?)

    @Query("SELECT * FROM publications")
    fun fetchPublications(): List<Publication>

    @Query("SELECT * FROM publications WHERE isFavorite == 1")
    fun fetchFavoritePublications(): List<Publication>

    @Update
    fun updateChangeFavoriteState(data: Publication)
}