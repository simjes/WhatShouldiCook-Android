package com.helpmeeat.simjes.whatshouldicook.shared

import android.support.v7.util.DiffUtil
import com.helpmeeat.simjes.whatshouldicook.models.Recipe

class RecipeDiffCallback(private val oldList: List<Recipe>, private val newList: List<Recipe> ) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRecipe: Recipe = oldList[oldItemPosition]
        val newRecipe: Recipe = newList[newItemPosition]

        return oldRecipe.title == newRecipe.title
    }
}