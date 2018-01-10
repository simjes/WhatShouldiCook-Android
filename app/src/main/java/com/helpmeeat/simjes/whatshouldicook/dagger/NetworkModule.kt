package com.helpmeeat.simjes.whatshouldicook.dagger

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://us-central1-whatshouldicook-865b3.cloudfunctions.net")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}