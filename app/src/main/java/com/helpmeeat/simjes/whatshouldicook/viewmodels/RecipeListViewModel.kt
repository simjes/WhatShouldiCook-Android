package com.helpmeeat.simjes.whatshouldicook.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.helpmeeat.simjes.whatshouldicook.dagger.DaggerAppComponent
import com.helpmeeat.simjes.whatshouldicook.models.Recipe
import com.helpmeeat.simjes.whatshouldicook.repositories.RecipeRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeListViewModel : ViewModel() {
    @Inject lateinit var recipeRepository: RecipeRepository
    var recipes: MutableLiveData<MutableList<Recipe>> = MutableLiveData()

    init {
        DaggerAppComponent.builder().build().injectRecipeRepository(this)
        recipes.value = mutableListOf()
        loadMoreRecipes()
    }

    fun loadMoreRecipes() {
        launch (CommonPool) {
            val newRecipe = recipeRepository.GetNextRecipes()!!
            val allRecipes = recipes.value
            if (allRecipes != null) {
                allRecipes += newRecipe
            }
            recipes.postValue(allRecipes)
        }
    }

    fun removeRecipe() {
        launch (CommonPool){
            val allRecipes = recipes.value
            if (allRecipes != null) {
                allRecipes.removeAt(0)
                recipes.postValue(allRecipes)
            }
        }
    }
}