package com.helpmeeat.simjes.whatshouldicook.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.helpmeeat.simjes.whatshouldicook.models.Recipe
import android.widget.TextView
import kotlinx.android.synthetic.main.recipe_card.view.*
import com.bumptech.glide.Glide
import com.helpmeeat.simjes.whatshouldicook.R.layout.recipe_card


class RecipeCardAdapter(context: Context): ArrayAdapter<Recipe>(context, 0) {

    override fun getView(position: Int, contentView: View, parent: ViewGroup): View {
        var contentView = contentView
        val holder: ViewHolder

        if (contentView == null) {
            val inflater = LayoutInflater.from(context)
            contentView = inflater.inflate(recipe_card, parent, false)
            holder = ViewHolder(contentView)
            contentView.setTag(holder)
        } else {
            holder = contentView.getTag() as ViewHolder
        }

        val recipe = getItem(position)

        holder.name.setText(recipe.name)
        holder.description.setText(recipe.description)
        Glide.with(context).load(recipe.url).into(holder.image)
        return contentView
    }

    private class ViewHolder(view: View) {
        var name: TextView
        var description: TextView
        var image: ImageView

        init {
            this.name = view.recipe_card_name
            this.description = view.recipe_card_description
            this.image = view.recipe_card_image
        }
    }
}