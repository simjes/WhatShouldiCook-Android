package com.helpmeeat.simjes.whatshouldicook.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.helpmeeat.simjes.whatshouldicook.R
import com.helpmeeat.simjes.whatshouldicook.adapters.RecipeCardAdapter
import com.helpmeeat.simjes.whatshouldicook.viewmodels.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import com.yuyakaido.android.cardstackview.SwipeDirection
import com.yuyakaido.android.cardstackview.CardStackView



class SwipeCardFragment : Fragment() {

    var adapter: RecipeCardAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setup()
        reload()
    }

    private fun createRecipes(): List<RecipeViewModel> {
        val recipes = ArrayList<RecipeViewModel>()
        recipes.add(RecipeViewModel(0, "Yasaka Shrine", "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800"))
        recipes.add(RecipeViewModel(1, "Fushimi Inari Shrine", "Kyoto", "https://source.unsplash.com/NYyCqdBOKwc/600x800"))
        recipes.add(RecipeViewModel(2, "Bamboo Forest", "Kyoto", "https://source.unsplash.com/buF62ewDLcQ/600x800"))
        recipes.add(RecipeViewModel(3, "Brooklyn Bridge", "New York", "https://source.unsplash.com/THozNzxEP3g/600x800"))
        recipes.add(RecipeViewModel(4, "Empire State Building", "New York", "https://source.unsplash.com/USrZRcRS2Lw/600x800"))
        recipes.add(RecipeViewModel(5, "The statue of Liberty", "New York", "https://source.unsplash.com/PeFk7fzxTdk/600x800"))
        recipes.add(RecipeViewModel(6, "Louvre Museum", "Paris", "https://source.unsplash.com/LrMWHKqilUw/600x800"))
        recipes.add(RecipeViewModel(7, "Eiffel Tower", "Paris", "https://source.unsplash.com/HN-5Z6AmxrM/600x800"))
        recipes.add(RecipeViewModel(8, "Big Ben", "London", "https://source.unsplash.com/CdVAUADdqEc/600x800"))
        recipes.add(RecipeViewModel(9, "Great Wall of China", "China", "https://source.unsplash.com/AWh9C-QjhE4/600x800"))
        return recipes
    }

    private fun createRecipeCardAdapter(): RecipeCardAdapter {
        val adapter = RecipeCardAdapter(this.context!!)
        adapter.addAll(createRecipes())
        return adapter
    }

    private fun setup() {
        fragment_card_stack_view.setCardEventListener(object: CardStackView.CardEventListener {
            override fun onCardDragging(percentX: Float, percentY: Float) {
                Log.d("CardStackView", "onCardDragging")
            }

            override fun onCardSwiped(direction: SwipeDirection) {
                Log.d("CardStackView", "onCardSwiped: " + direction.toString())
                Log.d("CardStackView", "topIndex: " + fragment_card_stack_view.getTopIndex())
               /* if (fragment_card_stack_view.getTopIndex() === adapter.getCount() - 5) {
                    Log.d("CardStackView", "Paginate: " + fragment_card_stack_view.getTopIndex())
                    paginate()
                }*/
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

    private fun reload() {
        fragment_card_stack_view.visibility = View.GONE
        fragment_progress_bar.visibility = View.VISIBLE
        Handler().postDelayed({
            adapter = createRecipeCardAdapter()
            fragment_card_stack_view.setAdapter(adapter)
            fragment_card_stack_view.visibility = View.VISIBLE
            fragment_progress_bar.visibility = View.GONE
        }, 1000)
    }

    /*private fun paginate() {
        fragment_card_stack_view.setPaginationReserved()
        adapter!!.addAll(createRecipeCardAdapter())
        adapter.notifyDataSetChanged()
    }*/
}
