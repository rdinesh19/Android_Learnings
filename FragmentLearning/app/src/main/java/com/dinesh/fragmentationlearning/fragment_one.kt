package com.dinesh.fragmentationlearning

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class fragment_one : Fragment(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shareoption_menu,menu)
        inflater.inflate(R.menu.overflow_menu,menu)

    }
    private fun getShareIntent(): Intent {
        val shareIntent=Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
        shareIntent.putExtra(Intent.EXTRA_TEXT,"TEXT")
        startActivity(Intent.createChooser(shareIntent,"share using"))
        return shareIntent}
    private fun shareSucess(){
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.shareoption_menu->shareSucess()
            R.id.aboutFragment->return NavigationUI.onNavDestinationSelected(
                item!!, view!!.findNavController()
            ) || super.onOptionsItemSelected(item)

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button).setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button -> navController!!.navigate(R.id.action_fragment_one_to_fragment_two)
        }

    }
}
