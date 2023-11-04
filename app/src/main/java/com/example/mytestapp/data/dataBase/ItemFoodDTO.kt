package com.Nekit120.codeholder.data.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mytestapp.domain.model.MenuItemModel


@Entity(tableName = "FoodItems")
data class ItemFoodDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo("imageUrl")
    val imageUrl: String,
    @ColumnInfo("name")
    val name:String,
    @ColumnInfo("content")
    val content:String,
    @ColumnInfo("cost")
    val cost : Int
) {
    constructor(menuItemMode:MenuItemModel) : this(menuItemMode.id, menuItemMode.imageUrl,menuItemMode.name,menuItemMode.content,menuItemMode.cost)
}
