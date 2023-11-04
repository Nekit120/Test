package com.Nekit120.codeholder.presentation.di
import com.Nekit120.codeholder.data.Database.MainDatabase
import com.example.mytestapp.presentation.App
import com.example.mytestapp.presentation.menu.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel<MenuViewModel>{
        MenuViewModel(get(),get())
    }

    single<MainDatabase>{
        App.database
    }

}