package com.helpmeeat.simjes.whatshouldicook.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.helpmeeat.simjes.whatshouldicook.R

/**
 * A placeholder fragment containing a simple view.
 */
class SwipeCardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}
