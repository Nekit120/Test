package com.example.mytestapp.data.repository

import com.Nekit120.codeholder.data.Database.ItemFoodDTO
import com.Nekit120.codeholder.data.Database.MainDatabase
import com.example.mytestapp.data.API.FoodAPI
import com.example.mytestapp.domain.model.Meal
import com.example.mytestapp.domain.model.MenuItemModel
import com.example.mytestapp.domain.repository.MenuRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuRepositoryImpl(var db: MainDatabase) : MenuRepository {

    override suspend fun getFoodListByCategory(category:String): List<Meal> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val foodApi = retrofit.create(FoodAPI::class.java)
            val foodList = foodApi.getFoodByCategory(category)
        return foodList.meals
    }

    override suspend fun insertCode(foodList: List<MenuItemModel>){
        val foodItemListDto : MutableList<ItemFoodDTO> = mutableListOf()
        for ( item in foodList){
            val foodItemDTO = ItemFoodDTO(item)
            foodItemListDto.add(foodItemDTO)
        }
        db.getMenuDao().deleteAllFoodItems()
        db.getMenuDao().insertCode(foodItemListDto)
    }

    override suspend fun getCodeList(): List<MenuItemModel> {
        val foodItemList : MutableList<MenuItemModel> = mutableListOf()
        db.getMenuDao().getFoodItems().forEach{ dto->
            val foodItem = MenuItemModel(dto.id,dto.imageUrl,dto.name,dto.content,dto.cost)
            foodItemList.add(foodItem)
        }
        return foodItemList
    }

}