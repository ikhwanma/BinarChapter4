package ikhwan.binar.chapterempat.sharedpref.latihantujuh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import ikhwan.binar.chapterempat.R

class SplashTujuhActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_tujuh)

        Handler().postDelayed(Runnable {
            val intent = Intent(this@SplashTujuhActivity, LoginTujuhActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}