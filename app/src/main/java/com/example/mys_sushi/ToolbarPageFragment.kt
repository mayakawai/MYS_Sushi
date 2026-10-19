package com.example.mys_sushi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

abstract class ToolbarPageFragment(
    @LayoutRes layoutId: Int,
    private val pageTitle: String
) : Fragment(layoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(toolbar)

        (requireActivity() as AppCompatActivity)
            .supportActionBar?.apply {
                title = pageTitle
                setDisplayHomeAsUpEnabled(false)
            }

        onPageReady(view, savedInstanceState)
    }

    protected open fun onPageReady(
        view: View,
        savedInstanceState: Bundle?
    ) {
        // Tempat mengatur komponen halaman
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater
    ) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(
        item: MenuItem
    ): Boolean {

        return when (item.itemId) {

            R.id.action_web -> {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://portal.pcr.ac.id/")
                )
                startActivity(intent)
                true
            }

            R.id.action_refresh -> {
                requireActivity().recreate()
                true
            }

            R.id.action_info -> {
                (requireActivity() as BottomNavigationHost)
                    .navigateTo(R.id.nav_profil)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}