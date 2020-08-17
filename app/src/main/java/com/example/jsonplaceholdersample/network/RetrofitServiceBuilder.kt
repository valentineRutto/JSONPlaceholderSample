package com.example.jsonplaceholdersample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitServiceBuilder {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            val okClientBuilder: OkHttpClient.Builder =
                OkHttpClient.Builder()
                    .connectTimeout(
                        20,
                        TimeUnit.SECONDS
                    )
                    .readTimeout(20, TimeUnit.SECONDS)

            val client: OkHttpClient = okClientBuilder.build()


            val retrofitBuilder: Retrofit.Builder =
                Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)

            retrofit = retrofitBuilder.build()

            return retrofit!!
        } else {
            return retrofit!!
        }
    }
}