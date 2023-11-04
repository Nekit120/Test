package com.example.mytestapp.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.mytestapp.R
import com.example.mytestapp.databinding.FragmentMenuBinding
import com.example.mytestapp.presentation.menu.adapters.CategoryAdapter
import com.example.mytestapp.presentation.menu.adapters.MenuAdapter
import com.example.mytestapp.presentation.menu.adapters.PageAdapter
import com.example.mytestapp.domain.model.CategoryItemModel
import com.example.mytestapp.domain.model.ItemModel
import com.example.mytestapp.domain.model.MenuItemModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment : Fragment(), CategoryAdapter.OnItemClickListener {

    private lateinit var binding: FragmentMenuBinding
    lateinit var  menuAdapter : MenuAdapter
    lateinit var  categoryAdapter : CategoryAdapter
    private var lastViewActive: View? = null
    private val viewModel: MenuViewModel by viewModel <MenuViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val categotyList = listOf<CategoryItemModel>(CategoryItemModel("Beef"), CategoryItemModel("Chicken"),
            CategoryItemModel("Dessert"), CategoryItemModel("Lamb"), CategoryItemModel("Miscellaneous"),
            CategoryItemModel("Pasta"), CategoryItemModel("Pork"), CategoryItemModel("Side"),
            CategoryItemModel("Starter"), CategoryItemModel("Vegan"), CategoryItemModel("Vegetarian"),
            CategoryItemModel("Breakfast")
        )
        viewModel.getListFoodByCategory("Beef")
        binding = FragmentMenuBinding.inflate(inflater)
        menuAdapter = MenuAdapter(requireActivity())
        binding.menuRecyclerView.adapter =menuAdapter
        //адаптер второй
        categoryAdapter = CategoryAdapter(listener = this)
        binding.categoryRecyclerView.adapter = categoryAdapter
        categoryAdapter.setData(categotyList)
        //viewPager
        val viewPager: ViewPager2 = binding.viewPager
        val items = listOf(
            ItemModel( R.drawable.discounts_4x),
            ItemModel(R.drawable.discounts2_4x),
        )
        val adapter = PageAdapter(requireActivity(), items)
        viewPager.adapter = adapter

        viewModel.resultListMenuLive.observe(requireActivity(),{listFoode->
            menuAdapter.setData(listFoode)
        })



 return binding.root
    }

    // можно через viewPager, но видимо в этот раз я лёгких путей не ищу... ( не подумал про то что rcView загружает определенное кол-во эллементов)
    override fun onItemClick(viewActive: View, position: Int) {
        val newTextColor = ContextCompat.getColor(viewActive.context, R.color.hot_pink)
        val lastTextColor = ContextCompat.getColor(viewActive.context, R.color.gray)
        val textView = viewActive.findViewById<TextView>(R.id.contentCategoryTv)
        viewModel.getListFoodByCategory(textView.text!!.toString())
        val linearLayoutView = viewActive.findViewById<LinearLayout>(R.id.linearLayoutCategory)
        textView.setTextColor(newTextColor)
        linearLayoutView.setBackgroundResource(R.drawable.bg_category_active)
        if (lastViewActive!=null && lastViewActive != viewActive){
            val lastTextView = lastViewActive!!.findViewById<TextView>(R.id.contentCategoryTv)
            val lastLinearLayoutView = lastViewActive!!.findViewById<LinearLayout>(R.id.linearLayoutCategory)
            lastLinearLayoutView.setBackgroundResource(R.drawable.bg_category)
            lastTextView.setTextColor(lastTextColor)
        }
        lastViewActive = viewActive
    }

}