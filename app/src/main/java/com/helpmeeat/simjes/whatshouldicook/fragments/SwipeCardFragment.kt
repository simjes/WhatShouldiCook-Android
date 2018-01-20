package com.helpmeeat.simjes.whatshouldicook.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.helpmeeat.simjes.whatshouldicook.R
import com.helpmeeat.simjes.whatshouldicook.adapters.RecipeCardAdapter
import com.helpmeeat.simjes.whatshouldicook.viewmodels.RecipeListViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import com.yuyakaido.android.cardstackview.SwipeDirection
import com.yuyakaido.android.cardstackview.CardStackView

class SwipeCardFragment : Fragment() {
    lateinit var recipeListViewModel: RecipeListViewModel
    lateinit var adapter: RecipeCardAdapter
    var counter = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel::class.java)
        adapter = RecipeCardAdapter(this.context!!)

        recipeListViewModel.recipes.observe(this, Observer { recipeList ->
            adapter.clear()
            adapter.addAll(recipeList)
            adapter.notifyDataSetChanged()
        })
        fragment_card_stack_view.setAdapter(adapter)
        fragment_card_stack_view.visibility = View.VISIBLE
        fragment_progress_bar.visibility = View.GONE

        setup()
    }

    private fun setup() {
        fragment_card_stack_view.setCardEventListener(object: CardStackView.CardEventListener {
            override fun onCardDragging(percentX: Float, percentY: Float) {
                Log.d("CardStackView", "onCardDragging")
            }

            override fun onCardSwiped(direction: SwipeDirection) {
                recipeListViewModel.removeRecipe()

                counter++
                if(counter % 4 == 0) {
                    recipeListViewModel.loadMoreRecipes()
                }

                Log.d("CardStackView", "onCardSwiped: " + direction.toString())
                Log.d("CardStackView", "topIndex: " + fragment_card_stack_view.topIndex)
            }

            override fun onCardReversed() {
                Log.d("CardStackView", "onCardReversed")
            }

            override fun onCardMovedToOrigin() {
                Log.d("CardStackView", "onCardMovedToOrigin")
            }

            override fun onCardClicked(index: Int) {
                Log.d("CardStackView", "onCardClicked: " + index)
            }
        })
    }
}
