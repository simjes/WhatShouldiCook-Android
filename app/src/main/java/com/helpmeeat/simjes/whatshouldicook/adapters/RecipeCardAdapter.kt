package com.helpmeeat.simjes.whatshouldicook.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.helpmeeat.simjes.whatshouldicook.viewmodels.RecipeViewModel
import android.widget.TextView
import kotlinx.android.synthetic.main.recipe_card.view.*
import com.bumptech.glide.Glide
import com.helpmeeat.simjes.whatshouldicook.R.layout.recipe_card


class RecipeCardAdapter(context: Context): ArrayAdapter<RecipeViewModel>(context, 0) {

    override fun getView(position: Int, contentView: View?, parent: ViewGroup): View {
        var contentView = contentView
        val holder: ViewHolder

        if (contentView == null) {
            val inflater = LayoutInflater.from(context)
            contentView = inflater.inflate(recipe_card, parent, false)
            holder = ViewHolder(contentView)
            contentView.tag = holder
        } else {
            holder = contentView.tag as ViewHolder
        }

        val recipe = getItem(position)

        holder.name.text = recipe.name
        holder.description.text = recipe.description
        Glide.with(context).load(recipe.url).into(holder.image)
        return contentView!!
    }

    private class ViewHolder(view: View) {
        var name: TextView = view.recipe_card_name
        var description: TextView = view.recipe_card_description
        var image: ImageView = view.recipe_card_image
    }
}