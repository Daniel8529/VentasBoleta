package com.example.ventasboletas.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.example.ventasboletas.data.EventosApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideSagApi(moshi: Moshi):EventosApi {
        return Retrofit.Builder()
            .baseUrl("https://bc31-190-94-102-188.ngrok-free.app/apiApp/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(EventosApi::class.java)

    }
}