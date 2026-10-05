package com.example.mys_sushi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "SIGAP"

        val btnSarpras =
            findViewById<android.widget.Button>(R.id.btnSarpras)

        val btnMonitoring =
            findViewById<android.widget.Button>(R.id.btnMonitoring)

        val btnPeminjaman =S
            findViewById<android.widget.Button>(R.id.btnPeminjaman)

        btnSarpras.setOnClickListener {

            val intent = Intent(this, SarprasActivity::class.java)
            startActivity(intent)

        }

        btnMonitoring.setOnClickListener {

            val intent = Intent(this, MonitoringActivity::class.java)
            startActivity(intent)

        }

        btnPeminjaman.setOnClickListener {

            val intent = Intent(this, PeminjamanActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.action_web -> {

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://portal.pcr.ac.id/")
                )

                startActivity(intent)

                true
            }

            R.id.action_info -> {

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}