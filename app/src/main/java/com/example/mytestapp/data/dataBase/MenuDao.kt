package com.Nekit120.codeholder.data.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuDao {

    @Query("SELECT * FROM FoodItems")
    fun getFoodItems(): List<ItemFoodDTO>

    @Query("DELETE FROM FoodItems")
    fun deleteAllFoodItems()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCode(foodItem:List<ItemFoodDTO>)
}
