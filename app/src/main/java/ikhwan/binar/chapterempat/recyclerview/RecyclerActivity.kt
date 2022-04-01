package ikhwan.binar.chapterempat.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val dataMhs = arrayListOf<DataMhs>(
            DataMhs("Ikhwan", 21, R.drawable.ic_android_black_24dp),
            DataMhs("Maulana", 20, R.drawable.ic_baseline_access_time_24),
            DataMhs("Akbar", 19, R.drawable.ic_baseline_add_circle_24),
            DataMhs("Ikhwn", 22, R.drawable.ic_baseline_add_reaction_24),
            DataMhs("Mlna", 18, R.drawable.ic_baseline_person_24),
            DataMhs("Akbr", 17, R.drawable.ic_baseline_access_time_24),
            DataMhs("Ikhwan", 21, R.drawable.ic_baseline_add_reaction_24),
            DataMhs("Maulana", 20, R.drawable.ic_baseline_access_time_24),
            DataMhs("Akbar", 19, R.drawable.ic_baseline_person_24),
        )

        val adapter = RecyclerAdapter(dataMhs)
        rv_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_recycler.adapter = adapter
    }
}