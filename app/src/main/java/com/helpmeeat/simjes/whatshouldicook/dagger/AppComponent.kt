package com.helpmeeat.simjes.whatshouldicook.dagger

import com.helpmeeat.simjes.whatshouldicook.repositories.RecipeRepository
import com.helpmeeat.simjes.whatshouldicook.viewmodels.RecipeListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RecipeModule::class, NetworkModule::class])
interface AppComponent {
    fun injectRecipeService(target: RecipeRepository)
    fun injectRecipeRepository(target: RecipeListViewModel)
}