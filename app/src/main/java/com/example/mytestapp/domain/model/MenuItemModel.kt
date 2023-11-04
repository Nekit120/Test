package com.example.mytestapp.domain.model

data class MenuItemModel(
    val id:Int? = null,
    val imageUrl: String,
    val name:String,
    val content:String,
    val cost : Int
)
