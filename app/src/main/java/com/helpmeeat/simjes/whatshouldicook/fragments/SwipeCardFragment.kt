package com.helpmeeat.simjes.whatshouldicook.fragments

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.ObservableList
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import com.github.nitrico.lastadapter.LastAdapter
import com.helpmeeat.simjes.whatshouldicook.BR
import com.helpmeeat.simjes.whatshouldicook.R
import com.helpmeeat.simjes.whatshouldicook.models.Recipe
import com.helpmeeat.simjes.whatshouldicook.shared.RecipeDiffCallback
import com.helpmeeat.simjes.whatshouldicook.viewmodels.RecipeListViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class SwipeCardFragment : Fragment() {
    lateinit var recipeListViewModel: RecipeListViewModel
    lateinit var adapter: LastAdapter
    lateinit var recipeList: MutableList<Recipe>
    private var initialLoad = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel::class.java)

        recipeList = mutableListOf()

        recipe_list_view.layoutManager = LinearLayoutManager(this.context)

        yesfab.setOnClickListener {
            recipeListViewModel.loadMoreRecipes()
        }

        nofab.setOnClickListener {
            recipeListViewModel.removeRecipe()
        }

        adapter = LastAdapter(recipeList, BR.item)
                .map<Recipe>(R.layout.recipe_card)
                .into(recipe_list_view)


        recipeListViewModel.recipes.observe(this, Observer { recipeList ->
            val diffCallback = RecipeDiffCallback(this.recipeList, recipeList!!)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            this.recipeList.clear()
            this.recipeList.addAll(recipeList)
            diffResult.dispatchUpdatesTo(adapter)

            if (this.recipeList.size != 0 && initialLoad) {
                fragment_progress_bar.visibility = View.GONE
                recipe_list_view.visibility = View.VISIBLE
                initialLoad = false
            }
        })
    }

}
