package com.k_design.example

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{const val URL3 = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita"  }
    var URL1 = "https://api.imgflip.com/get_memes"
    var URL1a = "https://api.imgflip.com/"
    var retrofit : Retrofit? = null

    fun getApiClientMultiLayout() : Retrofit?{
        retrofit = Retrofit.Builder()
            .baseUrl(URL1a)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}
