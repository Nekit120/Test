package com.example.mytestapp.presentation.menu.adapters

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytestapp.R
import com.example.mytestapp.databinding.FoodItemBinding
import com.example.mytestapp.domain.model.MenuItemModel

class MenuAdapter(private val context: Context, private var menuItemList: List<MenuItemModel> = emptyList()): RecyclerView.Adapter<MenuAdapter.ItemHolder>() {



    class ItemHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = FoodItemBinding.bind(view)


        fun hasInternetConnection(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

        fun setData(foodItem: MenuItemModel,context: Context) = with(binding){
            nameFood.text = foodItem.name
            contentFood.text = foodItem.content
            costTv.text = "от ${foodItem.cost} р"
            Glide.with(context).load(foodItem.imageUrl).into(imgFood)
            if (hasInternetConnection(context)) {
                Glide.with(context).load(foodItem.imageUrl).into(imgFood)
            } else {
                imgFood.setImageResource(R.drawable.error)
            }
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
      holder.setData(menuItemList[position],context)
    }

    fun setData(data: List<MenuItemModel>) {
        menuItemList = data
        notifyDataSetChanged()
    }


}