package ikhwan.binar.chapterempat.toastsnack.latihansatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ikhwan.binar.chapterempat.R
import ikhwan.binar.chapterempat.toastsnack.FirstActivity
import kotlinx.android.synthetic.main.activity_latihan_satu.*

class LatihanSatuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_satu)

        btn_welcome.setOnClickListener {
            val nama = input_nama.text.toString()
            Toast.makeText(this, "Welcome, $nama", Toast.LENGTH_LONG).show()
        }
        btn_intent.setOnClickListener {
            Snackbar.make(it, "Go to next page?", Snackbar.LENGTH_INDEFINITE).setAction("Go"){
                startActivity(Intent(this, FirstActivity::class.java))
            }.show()
        }
    }
}