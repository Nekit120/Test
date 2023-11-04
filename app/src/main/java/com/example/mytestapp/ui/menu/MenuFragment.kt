package com.example.mytestapp.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mytestapp.R
import com.example.mytestapp.databinding.FragmentHomeBinding
import com.example.mytestapp.ui.menu.adapters.CategoryAdapter
import com.example.mytestapp.ui.menu.adapters.MenuAdapter
import com.example.mytestapp.ui.menu.adapters.PageAdapter
import com.example.mytestapp.ui.model.CategoryItemModel
import com.example.mytestapp.ui.model.ItemModel
import com.example.mytestapp.ui.model.MenuItemModel

class MenuFragment : Fragment(), CategoryAdapter.OnItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    lateinit var  menuAdapter : MenuAdapter
    lateinit var  categoryAdapter : CategoryAdapter
    private var lastViewActive: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val menuList = listOf<MenuItemModel>(
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",333),
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",345),
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",400),
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",285),
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",120),
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",120),
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",120),
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",120),
            MenuItemModel(R.drawable.pizza,"Ветчина и грибы","Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",120)
        )
        val categotyList = listOf<CategoryItemModel>(
            CategoryItemModel("Пиццы"),
            CategoryItemModel("Салаты"),
            CategoryItemModel("Фунчоза"),
            CategoryItemModel("Роллы"),
            CategoryItemModel("Торты"),
            CategoryItemModel("Смузи"),
            CategoryItemModel("Выпивка")
        )
        binding = FragmentHomeBinding.inflate(inflater)
        menuAdapter = MenuAdapter()
        binding.menuRecyclerView.adapter =menuAdapter
        menuAdapter.setData(menuList)

        categoryAdapter = CategoryAdapter(listener = this)
        binding.categoryRecyclerView.adapter = categoryAdapter
        categoryAdapter.setData(categotyList)
        val viewPager: ViewPager2 = binding.viewPager
        val items = listOf(
            ItemModel( R.drawable.discounts_4x),
            ItemModel(R.drawable.discounts2_4x),
        )
        val adapter = PageAdapter(requireActivity(), items)
        viewPager.adapter = adapter


 return binding.root
    }
// можно через viewPager, но видимо в этот раз я лёгких путей не ищу .....
    override fun onItemClick(viewActive: View, position: Int) {
        val newTextColor = ContextCompat.getColor(viewActive.context, R.color.hot_pink)
        val lastTextColor = ContextCompat.getColor(viewActive.context, R.color.gray)
        val textView = viewActive.findViewById<TextView>(R.id.contentCategoryTv)
        val linearLayoutView = viewActive.findViewById<LinearLayout>(R.id.linearLayoutCategory)
        textView.setTextColor(newTextColor)
        linearLayoutView.setBackgroundResource(R.drawable.bg_category_active)
        if (lastViewActive!=null){
            val lastTextView = lastViewActive!!.findViewById<TextView>(R.id.contentCategoryTv)
            val lastLinearLayoutView = lastViewActive!!.findViewById<LinearLayout>(R.id.linearLayoutCategory)
            lastLinearLayoutView.setBackgroundResource(R.drawable.bg_category)
            lastTextView.setTextColor(lastTextColor)
        }
        lastViewActive = viewActive
    }

}