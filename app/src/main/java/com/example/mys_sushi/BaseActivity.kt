package com.example.mys_sushi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

interface BottomNavigationHost {
    fun navigateTo(menuId: Int)
}

class BaseActivity : AppCompatActivity(), BottomNavigationHost {

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        bottomNavView = findViewById(R.id.bottom_nav_view)

        bottomNavView.setOnItemSelectedListener { item ->

            val fragment: Fragment = when (item.itemId) {
                R.id.nav_dashboard -> DashboardFragment()
                R.id.nav_monitoring -> MonitoringFragment()
                R.id.nav_peminjaman -> PeminjamanFragment()
                R.id.nav_sarpras -> SarprasFragment()
                R.id.nav_profil -> DeveloperProfileFragment()
                else -> return@setOnItemSelectedListener false
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()

            true
        }

        if (savedInstanceState == null) {
            bottomNavView.selectedItemId = R.id.nav_dashboard
        }
    }

    override fun navigateTo(menuId: Int) {
        bottomNavView.selectedItemId = menuId
    }
}