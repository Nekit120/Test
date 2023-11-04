package com.Nekit120.codeholder.presentation.di

import com.example.mytestapp.domain.menuDomain.MenuDomainUseCase
import org.koin.dsl.module


val DomainModule = module {

    factory <MenuDomainUseCase> {
        MenuDomainUseCase(get())
    }
}