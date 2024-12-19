package com.example.kotlin_pr56.recept

import android.util.Log
import com.example.kotlin_pr56.retrofit.Api

class ReceptRepos(private  val receptDao: ReceptDAO, private val receptApi: Api) {
    suspend fun getReceptsFromApi(){

        for( i in 1..10) {
            val response = receptApi.getReсeptsById(i)
            Log.i("STATUS", response.toString())
            val recept = Recept(response.id, response.name, response.difficulty)
            insert(recept)
            Log.i("log","Загружено в БД")
        }
    }

    private suspend fun insert(recept: Recept){
        receptDao.insert(recept)
    }
    suspend fun getAllDogsFromBase() : List<Recept> {
        return receptDao.getAllRecepts()
    }

}