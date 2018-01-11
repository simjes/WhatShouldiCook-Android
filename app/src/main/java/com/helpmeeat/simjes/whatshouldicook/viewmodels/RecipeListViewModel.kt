package com.helpmeeat.simjes.whatshouldicook.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import com.helpmeeat.simjes.whatshouldicook.dagger.DaggerAppComponent
import com.helpmeeat.simjes.whatshouldicook.models.Recipe
import com.helpmeeat.simjes.whatshouldicook.repositories.RecipeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeListViewModel : ViewModel() {
    @Inject lateinit var recipeRepository: RecipeRepository
    var recipes = ObservableArrayList<Recipe>()

    init {
        DaggerAppComponent.builder().build().injectRecipeRepository(this)
        loadMoreRecipes()
    }

    fun loadMoreRecipes() {
         recipes.addAll(recipeRepository.GetNextRecipes())
    }

    fun removeCard() {
        recipes.removeAt(0)
    }
}