package com.helpmeeat.simjes.whatshouldicook.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.helpmeeat.simjes.whatshouldicook.viewmodels.RecipeViewModel
import com.helpmeeat.simjes.whatshouldicook.R
import com.helpmeeat.simjes.whatshouldicook.databinding.RecipeCardBinding


class RecipeCardAdapter(context: Context, private var recipes: ArrayList<RecipeViewModel>): ArrayAdapter<RecipeViewModel>(context, 0) {

    override fun getView(position: Int, contentView: View?, parent: ViewGroup): View {
        val recipeHolder: RecipeViewHolder
        if (contentView == null) {
            val recipeCardBinding: RecipeCardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recipe_card, parent, false)
            recipeHolder = RecipeViewHolder(recipeCardBinding)
            recipeHolder.view.tag = recipeHolder
        } else {
            recipeHolder = contentView.tag as RecipeViewHolder
        }
        recipeHolder.recipeCardBinding.recipe = recipes.get(position)

        return recipeHolder.view
    }

    private class RecipeViewHolder(var recipeCardBinding: RecipeCardBinding) {
        var view: View = recipeCardBinding.root

    }
}