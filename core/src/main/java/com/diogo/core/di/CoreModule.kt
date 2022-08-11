package com.diogo.core.di

import com.diogo.core.BuildConfig
import com.diogo.core.service.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal const val MODULE_NAME = "Core"

val coreModule = Kodein.Module(MODULE_NAME) {

    bind<HttpLoggingInterceptor>() with singleton {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    bind<OkHttpClient.Builder>() with singleton { OkHttpClient.Builder() }

    bind<OkHttpClient>() with singleton { instance<OkHttpClient.Builder>().build() }

    bind<GsonBuilder>() with singleton { GsonBuilder() }

    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create(instance()))
            .client(instance())
            .build()
    }

    bind<Gson>() with singleton { Gson() }

    bind<Retrofit.Builder>() with singleton { Retrofit.Builder() }

    bind<ApiService>() with singleton { instance<Retrofit>().create(ApiService::class.java) }
}