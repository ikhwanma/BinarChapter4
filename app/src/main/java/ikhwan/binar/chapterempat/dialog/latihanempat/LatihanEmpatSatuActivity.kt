package ikhwan.binar.chapterempat.dialog.latihanempat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_latihan_empat_satu.*
import kotlinx.android.synthetic.main.activity_latihan_empat_satu.tv_total
import kotlinx.android.synthetic.main.custom_empat_dialog.*
import kotlinx.android.synthetic.main.custom_empat_dialog.view.*

class LatihanEmpatSatuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_empat_satu)

        btn_custom.setOnClickListener {
            val barang = input_barang.text.toString()
            val jumlah = input_jumlah.text.toString().toInt()
            val harga = input_harga.text.toString().toInt()
            val jumlahHarga = jumlah * harga
            val view = LayoutInflater.from(this).inflate(R.layout.custom_empat_dialog,null, false)
            val dialog = AlertDialog.Builder(this).setView(view).create()

            view.tv_total.append(" Rp$jumlahHarga")
            view.btn_bayar.setOnClickListener {
                val bayar = view.input_bayar.text.toString().toInt()
                val txtBarang = "${getString(R.string.nama_barang)} : $barang"
                val txtjumlah = "${getString(R.string.jumlah)} $jumlah"
                val txtHarga = "${getString(R.string.harga)} Rp$harga"
                val txtTotal = "${getString(R.string.total)} Rp$jumlahHarga"
                val txtKembalian = "${getString(R.string.kembalian)} Rp${bayar - jumlahHarga}"

                if (bayar < jumlahHarga){
                    Toast.makeText(this, "Uang bayar kurang", Toast.LENGTH_SHORT).show()
                    view.input_bayar.setText("")
                }else{
                    dialog.dismiss()
                    card_struk.visibility = View.VISIBLE
                    tv_barang.text = txtBarang
                    tv_jumlah.text = txtjumlah
                    tv_harga.text = txtHarga
                    tv_total.text = txtTotal
                    tv_kembalian.text = txtKembalian

                }
            }

            dialog.show()
        }
        btn_dfragment.setOnClickListener {
            val barang = input_barang.text.toString()
            val jumlah = input_jumlah.text.toString().toInt()
            val harga = input_harga.text.toString().toInt()
            LatihanEmpatDialogFragment(barang, jumlah, harga).show(supportFragmentManager, null)
        }

        btn_clear.setOnClickListener {
            card_struk.visibility = View.INVISIBLE
            input_barang.setText("")
            input_harga.setText("")
            input_jumlah.setText("")
        }
    }
}