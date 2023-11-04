package com.example.mytestapp.ui.menu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestapp.R
import com.example.mytestapp.databinding.FoodItemBinding
import com.example.mytestapp.ui.model.MenuItemModel

class MenuAdapter(private var menuItemList: List<MenuItemModel> = emptyList()): RecyclerView.Adapter<MenuAdapter.ItemHolder>() {

    class ItemHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = FoodItemBinding.bind(view)
        fun setData(foodItem: MenuItemModel) = with(binding){
            nameFood.text = foodItem.name
            contentFood.text = foodItem.content
            costTv.text = "от ${foodItem.cost} р"

        }
        companion object{
                fun createItemHolder(parent: ViewGroup): ItemHolder {
                    return ItemHolder(LayoutInflater.from(parent.context).
                    inflate(R.layout.food_item,parent,false))
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.createItemHolder(parent)
    }

    override fun getItemCount() = menuItemList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
      holder.setData(menuItemList[position])
    }

    fun setData(data: List<MenuItemModel>) {
        menuItemList = data
        notifyDataSetChanged()
    }


}