package com.kotlin.pixelsoftwaresdemo.Retrofit

import com.kotlin.pixelsoftwaresdemo.Model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    fun getProducts(): Call<List<Product>>

}