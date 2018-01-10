package com.helpmeeat.simjes.whatshouldicook.repositories

import co.metalab.asyncawait.async
import com.helpmeeat.simjes.whatshouldicook.dagger.DaggerAppComponent
import com.helpmeeat.simjes.whatshouldicook.models.Recipe
import com.helpmeeat.simjes.whatshouldicook.models.RecipeResponse
import com.helpmeeat.simjes.whatshouldicook.services.RecipeApi
import com.helpmeeat.simjes.whatshouldicook.viewmodels.RecipeViewModel
import ru.gildor.coroutines.retrofit.Result
import ru.gildor.coroutines.retrofit.awaitResponse
import ru.gildor.coroutines.retrofit.awaitResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository {
    @Inject lateinit var recipeApi: RecipeApi

    init {
       DaggerAppComponent.builder().build().injectRecipeService(this)
    }

    fun GetNextRecipes(): ArrayList<RecipeViewModel> {

        async {
            val result = await {
                val response = recipeApi.getRandomRecipes().execute()
                if (response.isSuccessful) {
                    val recipes = response.body()


                }
                //Long running code
            }
            // Use result
        }

//        return when (result) {
//            is Result.Ok -> return result.value.recipes
//            is Result.Error -> throw Throwable("HTTP error: ${result.response.message()}")
//            is Result.Exception -> throw result.exception
//            else -> {
//                throw Throwable("Something went wrong, please try again later.")
//            }
//        }

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
        return recipes
    }

//    private fun process(response: RecipeResponse): RecipeResponse {
//        val dataResponse = response.data
//        val news = dataResponse.children.map {
//            val item = it.data
//            RedditNewsItem(item.author, item.title, item.num_comments,
//                    item.created, item.thumbnail, item.url)
//        }
//        return RedditNews(
//                dataResponse.after.orEmpty(),
//                dataResponse.before.orEmpty(),
//                news)
//    }
}