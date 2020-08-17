package com.example.jsonplaceholdersample.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitServiceBuilder {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            val httpLoggingInterceptor =
                HttpLoggingInterceptor()
            val loggingInterceptor =
                httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }

            val okClientBuilder: OkHttpClient.Builder =
                OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
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

    fun <T> buildService(service: Class<T>): T {
        return retrofit!!.create(service)
    }
}