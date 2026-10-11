
package com.example.mys_sushi

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mys_sushi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //mengakses SharedPreferences
        val sharedPreferences = getSharedPreferences(
            "UserSession",
            MODE_PRIVATE
        )

        //event tombol Masuk
        binding.btnMasuk.setOnClickListener {

            //mengambil email dan pw
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()

            //cek input
            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Email dan password wajib diisi!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            //validasi inputan
            if (email == "admin@gmail.com" && password == "123456") {

                //menyimpan status login
                sharedPreferences.edit()
                    .putBoolean("isLogin", true)
                    .putString("username", email)
                    .apply()

                Toast.makeText(
                    this,
                    "Login berhasil!",
                    Toast.LENGTH_SHORT
                ).show()

                //pindah ke DashboardActivity
                val intent = Intent(
                    this,
                    DashboardActivity::class.java
                )

                startActivity(intent)
                finish()

            } else {

                //jika email atau password salah
                Toast.makeText(
                    this,
                    "Email atau password salah!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
