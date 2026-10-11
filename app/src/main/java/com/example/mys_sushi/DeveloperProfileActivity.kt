package com.example.mys_sushi

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DeveloperProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //mnampilkan halaman profil
        setContentView(R.layout.activity_developer_profile)

        //tombol back
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }
    }
}
