package com.example.mys_sushi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class DashboardFragment :
    ToolbarPageFragment(
        R.layout.fragment_dashboard,
        "SIGAP"
    ) {

    companion object {
        private const val MENU_LOGOUT_ID = 1001
    }

    override fun onPageReady(
        view: View,
        savedInstanceState: Bundle?
    ) {
        view.findViewById<Button>(R.id.btnSarpras)
            .setOnClickListener {
                (requireActivity() as BottomNavigationHost)
                    .navigateTo(R.id.nav_sarpras)
            }

        view.findViewById<Button>(R.id.btnMonitoring)
            .setOnClickListener {
                (requireActivity() as BottomNavigationHost)
                    .navigateTo(R.id.nav_monitoring)
            }

        view.findViewById<Button>(R.id.btnPeminjaman)
            .setOnClickListener {
                (requireActivity() as BottomNavigationHost)
                    .navigateTo(R.id.nav_peminjaman)
            }
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater
    ) {
        super.onCreateOptionsMenu(menu, inflater)

        menu.add(
            Menu.NONE,
            MENU_LOGOUT_ID,
            Menu.NONE,
            "Logout"
        ).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)
    }

    override fun onOptionsItemSelected(
        item: MenuItem
    ): Boolean {

        if (item.itemId == MENU_LOGOUT_ID) {
            showLogoutDialog()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah kamu yakin ingin keluar?")
            .setNegativeButton("Batal", null)
            .setPositiveButton("Ya, Logout") { _, _ ->

                val sharedPreferences =
                    requireContext().getSharedPreferences(
                        "UserSession",
                        Context.MODE_PRIVATE
                    )

                sharedPreferences.edit()
                    .remove("isLogin")
                    .remove("username")
                    .apply()

                val intent = Intent(
                    requireContext(),
                    MainActivity::class.java
                ).apply {
                    flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK
                }

                startActivity(intent)
                requireActivity().finish()
            }
            .show()
    }
}