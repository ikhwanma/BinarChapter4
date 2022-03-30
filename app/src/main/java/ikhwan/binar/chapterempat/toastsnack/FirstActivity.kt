package ikhwan.binar.chapterempat.toastsnack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btn_toast.setOnClickListener {
            val data = "qwerty"
            Toast.makeText(this, "Ini toast $data", Toast.LENGTH_LONG).show()
        }

        btn_snack_satu.setOnClickListener {
            Snackbar.make(it, "Ini snackbar", Snackbar.LENGTH_LONG).show()
        }

        btn_snack_dua.setOnClickListener {
            Snackbar.make(it, "Ini snackbar action", Snackbar.LENGTH_INDEFINITE).setAction("Toast"){
                Toast.makeText(this, "Ini toast dari snackbar", Toast.LENGTH_SHORT).show()
            }.show()
        }

        btn_snack_tiga.setOnClickListener {
            val snackbar = Snackbar.make(it, "Ini snackbar dismiss", Snackbar.LENGTH_INDEFINITE)

            snackbar.setAction("Dismiss"){
                snackbar.dismiss()
            }

            snackbar.show()
        }


    }
}