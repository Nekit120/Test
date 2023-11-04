package com.example.mytestapp.domain.repository

import com.example.mytestapp.domain.model.Meal
import com.example.mytestapp.domain.model.MenuItemModel

interface MenuRepository {

    suspend fun getFoodListByCategory(category: String) : List<Meal>
    suspend fun insertCode(foodList: List<MenuItemModel>)
    suspend fun getCodeList(): List<MenuItemModel>
}