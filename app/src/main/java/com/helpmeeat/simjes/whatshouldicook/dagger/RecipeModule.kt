package com.helpmeeat.simjes.whatshouldicook.dagger

import com.helpmeeat.simjes.whatshouldicook.repositories.RecipeRepository
import com.helpmeeat.simjes.whatshouldicook.services.RecipeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RecipeModule {
    @Provides
    @Singleton
    fun provideRecipeRepository() : RecipeRepository = RecipeRepository()

    @Provides
    @Singleton
    fun provideRecipeService(retrofit: Retrofit) : RecipeApi = retrofit.create(RecipeApi::class.java)
}