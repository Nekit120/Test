package com.example.mytestapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytestapp.databinding.FragmentDashboardBinding
import com.example.mytestapp.ui.menu.adapters.CategoryAdapter
import com.example.mytestapp.ui.model.CategoryItemModel

class DashboardFragment : Fragment() {

    lateinit var binding: FragmentDashboardBinding
    lateinit var  categoryAdapter : CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        binding = FragmentDashboardBinding.inflate(inflater)
        val root: View = binding.root



        return root
    }
}