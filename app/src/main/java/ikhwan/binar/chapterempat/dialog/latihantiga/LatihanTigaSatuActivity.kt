package ikhwan.binar.chapterempat.dialog.latihantiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_latihan_tiga_satu.*

class LatihanTigaSatuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_tiga_satu)

        btn_standard.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Latihan 2")
                .setMessage("Buat AlertDialog aksi yang menampilkan hasil perkalian")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(true)
                .show()
        }

        btn_aksi.setOnClickListener {
            val x = input_x.text.toString().toInt()
            val y = input_y.text.toString().toInt()
            val z = x * y

            AlertDialog.Builder(this).setTitle("Hasil perkalian")
                .setMessage("Hasil $x x $y = $z")
                .setIcon(R.mipmap.ic_launcher)
                .setNegativeButton("Dismiss"){p0, p1->
                    p0.dismiss()
                }.show()
        }


    }
}