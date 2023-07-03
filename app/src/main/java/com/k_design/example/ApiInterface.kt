package com.k_design.example

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {

    @GET
    fun GetMultilayout(@Url url: String) : Call<MultiLayoutModul>

}
