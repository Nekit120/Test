package com.example.mytestapp.presentation.menu

import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestapp.domain.menuDomain.MenuDomainUseCase
import com.example.mytestapp.domain.model.Meal
import com.example.mytestapp.domain.model.MenuItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel(val menuDomainUseCase: MenuDomainUseCase, val context: Context) : ViewModel() {

    private val resultListMenu = MutableLiveData<List<MenuItemModel>>()
    val resultListMenuLive: LiveData<List<MenuItemModel>> = resultListMenu

    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun getListFoodByCategory(category:String){
        viewModelScope.launch(Dispatchers.IO) {
            if (hasInternetConnection(context)) {
                val resulMenuList = menuDomainUseCase.getListFoodByCategory(category)
                val menuListByCategory = mutableListOf<MenuItemModel>()
                for(itemFood in resulMenuList){
                    menuListByCategory.add(MenuItemModel(null,itemFood.strMealThumb,itemFood.strMeal,"This information is not yet available in the open Api, you will have to wait",300))
                }
                insertListFoodInDataBase(menuListByCategory)
                resultListMenu.postValue(menuListByCategory)
            } else {
                getListFoodFromDataBase()
            }
        }
    }

    fun insertListFoodInDataBase (foodList: List<MenuItemModel>) {
        viewModelScope.launch(Dispatchers.IO) {
            menuDomainUseCase.insertListFoodInDataBase(foodList)
        }
    }
        fun getListFoodFromDataBase() {
            viewModelScope.launch(Dispatchers.IO) {
                resultListMenu.postValue(menuDomainUseCase.getListFoodFromDataBase())
            }
        }

}
