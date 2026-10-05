package com.example.mys_sushi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SarprasActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_sarpras)

            val toolbar = findViewById<Toolbar>(R.id.toolbar)

            setSupportActionBar(toolbar)

            supportActionBar?.title = "Kelola Sarpras"

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.toolbar_menu, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                android.R.id.home -> {
                    finish()
                    true
                }

                R.id.action_refresh -> {
                    recreate()
                    true
                }

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