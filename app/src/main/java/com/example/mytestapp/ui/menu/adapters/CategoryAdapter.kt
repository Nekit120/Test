package com.example.mytestapp.ui.menu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestapp.R
import com.example.mytestapp.databinding.ItemCategoryBinding
import com.example.mytestapp.ui.model.CategoryItemModel

class CategoryAdapter(private var categoryItemModelList: List<CategoryItemModel> = emptyList(), private val listener: OnItemClickListener): RecyclerView.Adapter<CategoryAdapter.ItemHolder>() {

    class ItemHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemCategoryBinding.bind(view)
        fun setData(categoryItem: CategoryItemModel,listener:OnItemClickListener) = with(binding){
            contentCategoryTv.text = categoryItem.content
           itemView.setOnClickListener {
                listener.onItemClick(itemView, position)
            }

        }
        companion object{
                fun createItemHolder(parent: ViewGroup): ItemHolder {
                    return ItemHolder(LayoutInflater.from(parent.context).
                    inflate(R.layout.item_category,parent,false))
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.createItemHolder(parent)
    }

    override fun getItemCount() = categoryItemModelList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

      holder.setData(categoryItemModelList[position],listener)
    }

    fun setData(data: List<CategoryItemModel>) {
        categoryItemModelList = data
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}