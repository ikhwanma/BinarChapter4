package ikhwan.binar.chapterempat.recyclerview.latihanlima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ikhwan.binar.chapterempat.R
import ikhwan.binar.chapterempat.recyclerview.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_lima_satu.*
import kotlinx.android.synthetic.main.activity_recycler.*

class LimaSatuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lima_satu)

        val listApp = arrayListOf<Aplikasi>(
            Aplikasi(
                R.drawable.img_binar1,
                "Binar Academy",
                "Binar Academy",
                "Education",
                4.7,
                "13 MB",
                "1K+"
            ),
            Aplikasi(
                R.drawable.img_binar2,
                "Binar X",
                "Binar Academy",
                "Education",
                4.5,
                "9.8 MB",
                "5K+"
            ),
            Aplikasi(
                R.drawable.img_binary,
                "Binary Code Translator",
                "TimeToast",
                "Tools",
                4.5,
                "1.3 MB",
                "1M+"
            ),
        )

        val adapter = LimaAdapter(listApp)
        rv_lima.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_lima.adapter = adapter
    }
}