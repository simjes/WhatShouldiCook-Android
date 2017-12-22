package com.helpmeeat.simjes.whatshouldicook.activities

import android.app.Application
import com.helpmeeat.simjes.whatshouldicook.dagger.AppComponent
import com.helpmeeat.simjes.whatshouldicook.dagger.AppModule
import com.helpmeeat.simjes.whatshouldicook.dagger.DaggerAppComponent

class HelpMeEatApplication: Application() {
    lateinit var recipeComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        recipeComponent = initDagger(this)
    }

    private fun initDagger(app: HelpMeEatApplication): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
}