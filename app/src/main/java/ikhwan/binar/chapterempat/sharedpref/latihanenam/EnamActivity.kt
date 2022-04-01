package ikhwan.binar.chapterempat.sharedpref.latihanenam

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_enam.*

class EnamActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enam)

        sharedPreferences = getSharedPreferences("PREF", Context.MODE_PRIVATE)

        btn_save.setOnClickListener {
            val id = input_id.text.toString()
            val name = input_nama.text.toString()
            sharedPreferences.edit().putString("id", id).putString("name", name).apply()
            Toast.makeText(this, "Data disimpan", Toast.LENGTH_SHORT).show()
            input_id.setText("")
            input_nama.setText("")
        }
        btn_view.setOnClickListener {
            val txtName = "Namamu ${sharedPreferences.getString("name", "")}"
            val txtId = "Idmu ${sharedPreferences.getString("id", "")}"

            if (sharedPreferences.contains("name")){
                tv_nama.text = txtName
                tv_id.text = txtId
            }else{
                Toast.makeText(this, "Data tidak ada", Toast.LENGTH_SHORT).show()
            }
        }
        btn_clear.setOnClickListener {
            val txtName = "Namamu "
            val txtId = "Idmu "

            sharedPreferences.edit().clear().apply()

            tv_id.text = txtId
            tv_nama.text = txtName

            Toast.makeText(this, "Data Dihapus", Toast.LENGTH_SHORT).show()
        }
    }

}