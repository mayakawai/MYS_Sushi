
package com.example.mys_sushi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DashboardActivity : AppCompatActivity() {

    //menu Logout
    companion object {
        private const val MENU_LOGOUT_ID = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //menampilkan layout Dashboard
        setContentView(R.layout.activity_dashboard)

        //mengatur Toolbar SIGAP
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "SIGAP"

        //menghubungkan tombol Dashboard
        val btnSarpras =
            findViewById<Button>(R.id.btnSarpras)

        val btnMonitoring =
            findViewById<Button>(R.id.btnMonitoring)

        val btnPeminjaman =
            findViewById<Button>(R.id.btnPeminjaman)

        //tombol Kelola Sarpras
        btnSarpras.setOnClickListener {

            val intent = Intent(
                this,
                SarprasActivity::class.java
            )

            startActivity(intent)
        }

        //tombol Monitoring Sarpras
        btnMonitoring.setOnClickListener {

            val intent = Intent(
                this,
                MonitoringActivity::class.java
            )

            startActivity(intent)
        }

        //tombol Lihat Peminjaman
        btnPeminjaman.setOnClickListener {

            val intent = Intent(
                this,
                PeminjamanActivity::class.java
            )

            startActivity(intent)
        }
    }

    //menampilkan menu Toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        //mengambil menu dari toolbar_menu.xml
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        //menambahkan Logout
        menu.add(
            Menu.NONE,
            MENU_LOGOUT_ID,
            Menu.NONE,
            "Logout"
        ).setShowAsAction(
            MenuItem.SHOW_AS_ACTION_NEVER
        )

        return true
    }

    //menangani klik menu Toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            //menu Web Sarpras
            R.id.action_web -> {

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://portal.pcr.ac.id/")
                )

                startActivity(intent)

                true
            }

            //menu Refresh Dashboard
            R.id.action_refresh -> {

                recreate()

                true
            }

            //menu Developer Profile
            R.id.action_info -> {

                val intent = Intent(
                    this,
                    DeveloperProfileActivity::class.java
                )

                startActivity(intent)

                true
            }

            //menu Logout
            MENU_LOGOUT_ID -> {

                showLogoutDialog()

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showLogoutDialog() {

        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah kamu yakin ingin keluar?")
            .setNegativeButton("Batal", null)

            .setPositiveButton("Ya, Logout") { _, _ ->

                //membuka SharedPreferences
                val sharedPreferences = getSharedPreferences(
                    "UserSession",
                    MODE_PRIVATE
                )

                //menghapus status login
                sharedPreferences.edit()
                    .remove("isLogin")
                    .remove("username")
                    .apply()

                //kembali ke MainActivity (Login)
                val intent = Intent(
                    this,
                    MainActivity::class.java
                )

                //menghapus riwayat Activity
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)
                finish()
            }
            .show()
    }
}
