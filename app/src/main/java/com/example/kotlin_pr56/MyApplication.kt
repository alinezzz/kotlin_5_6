package com.example.kotlin_pr56

import android.app.Application
import androidx.room.Room
import com.example.kotlin_pr56.recept.ReceptDB
import com.example.kotlin_pr56.retrofit.Api
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    private val appModule = module{
        single {
            Retrofit.Builder().baseUrl("https://dummyjson.com/").addConverterFactory(
                GsonConverterFactory.create()).build().create(Api::class.java) }
        single { Room.databaseBuilder(applicationContext, ReceptDB::class.java,"recept_db")
            .build().receptDao()}
    }
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}