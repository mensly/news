package com.yourname.news

import android.app.Application
import com.yourname.news.services.NewsRepository
import com.yourname.news.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val serviceModule = module {
            single { NewsRepository() }
        }
        val viewModelModule = module(override = true) {
            viewModel { MainViewModel(get()) }
        }
        startKoin {
            androidContext(this@App)
            modules(serviceModule, viewModelModule)
        }
    }
}
