package com.example.mys_sushi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //menampilkan SplashScreen
        setContentView(R.layout.activity_splash_screen)

        val sharedPreferences = getSharedPreferences(
            "UserSession",
            MODE_PRIVATE
        )

        val isLogin = sharedPreferences.getBoolean(
            "isLogin",
            false
        )

        //menunggu 2 detik
        Handler(Looper.getMainLooper()).postDelayed({

            //cek status login
            if (isLogin) {
                startActivity(
                    Intent(this, BaseActivity::class.java)
                )
            } else {
                startActivity(
                    Intent(this, MainActivity::class.java)
                )
            }

            finish()

        }, 2000)
    }
}
