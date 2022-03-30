package ikhwan.binar.chapterempat.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.custom_alert_dialog.view.*

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btn_standard.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Ini Title")
            dialog.setMessage("Ini messagenya")
            dialog.setIcon(R.mipmap.ic_launcher)
            dialog.setCancelable(true)
            dialog.show()
        }

        btn_aksi.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Ini Title Aksi")
            dialog.setMessage("Ini Message Aksi")
            dialog.setIcon(R.mipmap.ic_launcher)
            dialog.setPositiveButton("Positive") { p0, p1 ->
                Toast.makeText(this, "Ini positive", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("Negative") { p0, p1 ->
                Toast.makeText(this, "Ini negative", Toast.LENGTH_SHORT).show()
            }
            dialog.setNeutralButton("Neutral") { p0, p1 ->
                Toast.makeText(this, "Ini neutral", Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }

        btn_aksi2.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Example Dismiss")
            dialog.setMessage("Ini Contoh Dismiss")
            dialog.setIcon(R.mipmap.ic_launcher)
            dialog.setPositiveButton("Ya") { p0, p1 ->
                Toast.makeText(this, "Ini positive", Toast.LENGTH_SHORT).show()
            }
            dialog.setNeutralButton("Dismiss") { p0, p1 ->
                p0.dismiss()
            }
            dialog.show()
        }

        btn_custom.setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.custom_alert_dialog, null, false)
            val dialog = AlertDialog.Builder(this).setView(view).create()

            view.btn_close.setOnClickListener {
                val nama = view.input_nama.text.toString()
                Toast.makeText(this, "Halo $nama", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialog.show()

        }

        btn_dfragment.setOnClickListener {
            ContohDialogFragment().show(supportFragmentManager, null)
        }

    }
}