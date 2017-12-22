package com.helpmeeat.simjes.whatshouldicook.dagger

import com.helpmeeat.simjes.whatshouldicook.viewmodels.RecipeListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RecipeModule::class])
interface AppComponent {
    fun inject(target: RecipeListViewModel)
}