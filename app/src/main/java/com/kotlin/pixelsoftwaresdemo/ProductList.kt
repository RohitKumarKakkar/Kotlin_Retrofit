package com.kotlin.pixelsoftwaresdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.pixelsoftwaresdemo.Adapter.RecyclerAdapterProducts
import com.kotlin.pixelsoftwaresdemo.Model.Product
import com.kotlin.pixelsoftwaresdemo.Retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

        val call: Call<List<Product>> = ApiClient.getClient.getProducts()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>?,
                response: Response<List<Product>>?
            ) {
                val data: ArrayList<Product>
                data = response?.body() as ArrayList<Product>
                val adapter = RecyclerAdapterProducts(data)
                recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<List<Product>>?, t: Throwable?) {
                Toast.makeText(this@ProductList, "" + t, Toast.LENGTH_SHORT).show()
            }
        })


    }
}