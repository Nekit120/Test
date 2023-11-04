package com.example.mytestapp.data.API

import com.example.mytestapp.domain.model.FoodItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodAPI {
    @GET("api/json/v1/1/filter.php")
    suspend fun getFoodByCategory(@Query("c") category: String) : FoodItem
}