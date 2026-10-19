package com.example.mys_sushi

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class DeveloperProfileFragment :
    Fragment(R.layout.fragment_developer_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Profil tidak menggunakan menu Toolbar
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // Menghapus Toolbar halaman sebelumnya
        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(null)

        requireActivity().invalidateOptionsMenu()

        // Tombol kembali menuju Dashboard
        view.findViewById<Button>(R.id.btnBack)
            .setOnClickListener {
                (requireActivity() as BottomNavigationHost)
                    .navigateTo(R.id.nav_dashboard)
            }
    }
}
