package ikhwan.binar.chapterempat.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_shared_pref.*

class SharedPrefActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        sharedPreferences = getSharedPreferences("SHARED", Context.MODE_PRIVATE)

        if (sharedPreferences.contains("NAME")) {
            startActivity(Intent(this, SharedPrefDuaActivity::class.java))
            finish()
        }

        btn_simpan.setOnClickListener {
            val nama = input_nama.text.toString()
            sharedPreferences.edit().putString("NAME", nama).apply()
            startActivity(Intent(this, SharedPrefDuaActivity::class.java))
            finish()
        }

    }
}