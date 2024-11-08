package com.example.app.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@ComponentScan
class RemoteModule {

    private val url="https://akabab.github.io/superhero-api/api/"

    @Single
    fun provideLogginInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY

    }

    @Single
    fun provideOkHttpClient(loginInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(loginInterceptor)

        return okHttpClient.build()
    }

    @Single
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit

    }

}