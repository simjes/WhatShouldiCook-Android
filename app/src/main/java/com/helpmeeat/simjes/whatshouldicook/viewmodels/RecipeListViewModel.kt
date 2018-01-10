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
    var recipes = ObservableArrayList<RecipeViewModel>()

    init {
        DaggerAppComponent.builder().build().injectRecipeRepository(this)
        loadMoreRecipes()
    }

    fun loadMoreRecipes() {
//        recipes.addAll(recipeRepository.GetNextRecipes())
        //todo: automap to RecipeViewModel

        val recipes = ArrayList<RecipeViewModel>(listOf(
                RecipeViewModel(0, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800"),
                RecipeViewModel(1, "Fushimi Inari Shrine", "Kyoto", "https://source.unsplash.com/NYyCqdBOKwc/600x800"),
                RecipeViewModel(2, "Bamboo Forest", "Kyoto", "https://source.unsplash.com/buF62ewDLcQ/600x800"),
                RecipeViewModel(3, "Brooklyn Bridge", "New York", "https://source.unsplash.com/THozNzxEP3g/600x800"),
                RecipeViewModel(4, "Empire State Building", "New York", "https://source.unsplash.com/USrZRcRS2Lw/600x800"),
                RecipeViewModel(5, "The statue of Liberty", "New York", "https://source.unsplash.com/PeFk7fzxTdk/600x800"),
                RecipeViewModel(6, "Louvre Museum", "Paris", "https://source.unsplash.com/LrMWHKqilUw/600x800"),
                RecipeViewModel(7, "Eiffel Tower", "Paris", "https://source.unsplash.com/HN-5Z6AmxrM/600x800"),
                RecipeViewModel(8, "Big Ben", "London", "https://source.unsplash.com/CdVAUADdqEc/600x800"),
                RecipeViewModel(9, "Great Wall of China", "China", "https://source.unsplash.com/AWh9C-QjhE4/600x800")
        )
        )
        this.recipes.addAll(recipes)
    }

    fun removeCard() {
        recipes.removeAt(0)
    }
}