package ikhwan.binar.chapterempat.sharedpref.latihantujuh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_home_tujuh.*

class HomeTujuhActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_tujuh)
        sharedPreferences = getSharedPreferences(LoginTujuhActivity.PREF_NAME, Context.MODE_PRIVATE)

        val txtName = "Halo, ${sharedPreferences.getString(LoginTujuhActivity.USERNAME, "")}"
        tv_nama.text = txtName

        btn_logout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah anda yakin ingin logout?")
                .setIcon(R.drawable.img_binar2)
                .setPositiveButton("Ya") { p0, p1 ->
                    sharedPreferences.edit().clear().apply()
                    startActivity(Intent(this, LoginTujuhActivity::class.java))
                    finish()
                }
                .setNegativeButton("Tidak") { p0, p1 ->
                }.show()
        }
    }
}