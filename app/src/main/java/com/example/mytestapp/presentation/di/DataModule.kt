package com.Nekit120.codeholder.presentation.di
import com.Nekit120.codeholder.data.Database.MainDatabase
import com.example.mytestapp.data.repository.MenuRepositoryImpl
import com.example.mytestapp.domain.repository.MenuRepository
import com.example.mytestapp.presentation.App
import org.koin.dsl.module


val DataModule = module {

    single<MenuRepository> {
        MenuRepositoryImpl(get())
    }

}

