package com.helpmeeat.simjes.whatshouldicook.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.helpmeeat.simjes.whatshouldicook.R
import com.helpmeeat.simjes.whatshouldicook.databinding.RecipeCardBinding
import com.helpmeeat.simjes.whatshouldicook.models.Recipe


class RecipeCardAdapter(context: Context): ArrayAdapter<Recipe>(context, 0) {
    override fun getView(position: Int, contentView: View?, parent: ViewGroup): View {
        val binding = contentView?.tag as? RecipeCardBinding ?:  DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.recipe_card, parent, false)
        binding.recipe = this.getItem(position)
        binding.root.tag = binding

        return binding.root
    }
}