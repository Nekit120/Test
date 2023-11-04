package com.example.mytestapp.presentation

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.Nekit120.codeholder.data.Database.MainDatabase
import com.Nekit120.codeholder.presentation.di.AppModule
import com.Nekit120.codeholder.presentation.di.DataModule
import com.Nekit120.codeholder.presentation.di.DomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    companion object {
        lateinit var instance: App
        val database by lazy { MainDatabase.getDatabase(context = instance) }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin{

            androidContext(this@App)
            modules(listOf(AppModule,DataModule, DomainModule))
        }

    }
}