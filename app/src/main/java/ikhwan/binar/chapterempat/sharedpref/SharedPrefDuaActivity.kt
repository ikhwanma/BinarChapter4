package ikhwan.binar.chapterempat.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_shared_pref_dua.*

class SharedPrefDuaActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref_dua)

        sharedPreferences = getSharedPreferences("SHARED", Context.MODE_PRIVATE)

        tv_nama.text = sharedPreferences.getString("NAME", "")

        btn_logout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this, SharedPrefActivity::class.java))
            finish()
        }
    }
}