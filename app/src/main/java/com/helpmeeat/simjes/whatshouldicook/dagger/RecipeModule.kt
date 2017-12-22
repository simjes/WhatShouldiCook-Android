package com.helpmeeat.simjes.whatshouldicook.dagger

import com.helpmeeat.simjes.whatshouldicook.repositories.RecipeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RecipeModule {
    @Provides
    @Singleton
    fun provideRecipeRepository() : RecipeRepository = RecipeRepository()
}