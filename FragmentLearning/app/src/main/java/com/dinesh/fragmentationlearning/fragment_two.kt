package com.dinesh.fragmentationlearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_two.view.*

class fragment_two : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_two, container, false)
        view.button.setOnClickListener{Navigation.findNavController(view).navigate(R.id.action_fragment_two_to_fragment_three)}
        return view
    }
}