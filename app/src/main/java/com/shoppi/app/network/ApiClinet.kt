package com.shoppi.app.network

import com.shoppi.app.model.Category
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiClinet {

    @GET("categories.json")
    suspend fun getCategories() : List<Category>

    companion object {
        private const val baseUrl = "https://shoppi-45b38-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create() : ApiClinet {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClinet::class.java)
        }
    }
}