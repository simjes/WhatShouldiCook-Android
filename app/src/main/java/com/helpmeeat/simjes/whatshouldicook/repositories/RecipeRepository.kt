package com.helpmeeat.simjes.whatshouldicook.repositories

import com.helpmeeat.simjes.whatshouldicook.dagger.DaggerAppComponent
import com.helpmeeat.simjes.whatshouldicook.models.Recipe
import com.helpmeeat.simjes.whatshouldicook.services.RecipeApi
import ru.gildor.coroutines.retrofit.awaitResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository {
    @Inject lateinit var recipeApi: RecipeApi

    init {
       DaggerAppComponent.builder().build().injectRecipeService(this)
    }
    suspend fun GetNextRecipes(): MutableList<Recipe>? {
        val recipes = recipeApi.getRandomRecipes().awaitResponse()
        return recipes.body()
    }
}