package com.yourname.news

import android.app.Application
import com.yourname.news.services.NewsRepository
import com.yourname.news.services.NewsRepositoryImpl
import com.yourname.news.services.Rss2JsonApi
import com.yourname.news.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val serviceModule = module {
            single<NewsRepository> { NewsRepositoryImpl(get()) }
            single {
                Retrofit.Builder()
                    .baseUrl("https://api.rss2json.com/v1/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                    .create<Rss2JsonApi>()
            }
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
