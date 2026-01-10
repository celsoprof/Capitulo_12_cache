package br.com.fiap.receitasapp.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val BASE_URL = "http://10.0.2.2:8080/api/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getReceitaApi(): ReceitaApi{
        return retrofitFactory.create(ReceitaApi::class.java)
    }

}