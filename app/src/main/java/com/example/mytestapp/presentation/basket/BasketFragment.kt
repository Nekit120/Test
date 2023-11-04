package com.example.mytestapp.presentation.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytestapp.databinding.FragmentBasketBinding
import com.example.mytestapp.presentation.menu.adapters.CategoryAdapter

class BasketFragment : Fragment() {

    lateinit var binding: FragmentBasketBinding
    lateinit var  categoryAdapter : CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val basketViewModel =
            ViewModelProvider(this).get(BasketViewModel::class.java)

        binding = FragmentBasketBinding.inflate(inflater)
        val root: View = binding.root
        return root
    }
}