package com.devsparkle.starwarsapp.di

import android.content.Context
import com.devsparkle.starwarsapp.BuildConfig
import com.devsparkle.starwarsapp.data.local.AppDatabase
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * In this module we will provide every classes that used for the whole application and every activities
 */
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {



    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val okHttpBuilder = OkHttpClient.Builder()
        // debug interceptor like Stetho and http logging interceptor
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(logging)
            okHttpBuilder.addNetworkInterceptor(StethoInterceptor())
        }
        return okHttpBuilder.apply {
            readTimeout(10, TimeUnit.SECONDS)
            connectTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
            callTimeout(10, TimeUnit.SECONDS)
        }
    }


    @Provides
    fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()

            .addConverterFactory(ScalarsConverterFactory.create()) // to allow to get or post scalar type like String for example directly
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }


    @Provides
    fun provideBaseRetrofit(retrofitBuilder: Retrofit.Builder, client: OkHttpClient.Builder
    ): Retrofit {
        return retrofitBuilder
            .client(client.build()) .baseUrl("https://swapi.dev/api/")
            .build()
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)



}
