package com.example.mytestapp.domain.menuDomain

import com.example.mytestapp.domain.model.Meal
import com.example.mytestapp.domain.model.MenuItemModel
import com.example.mytestapp.domain.repository.MenuRepository

class MenuDomainUseCase(val menuRepository: MenuRepository) {

    suspend fun getListFoodByCategory(category:String) : List<Meal> {
    return menuRepository.getFoodListByCategory(category)
    }

    suspend fun getListFoodFromDataBase() : List<MenuItemModel> {
        return menuRepository.getCodeList()
    }

    suspend fun insertListFoodInDataBase (foodList: List<MenuItemModel>) {
        menuRepository.insertCode(foodList)
    }

}