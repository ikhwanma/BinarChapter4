package ikhwan.binar.chapterempat.dialog.latihanempat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_latihan_empat_satu.*
import kotlinx.android.synthetic.main.activity_latihan_empat_satu.tv_total
import kotlinx.android.synthetic.main.fragment_latihan_empat_dialog.*

class LatihanEmpatDialogFragment(val barang: String, val jumlah: Int, val harga: Int) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_latihan_empat_dialog, container, false)
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jumlahHarga = jumlah * harga

        tv_total.append(" Rp$jumlahHarga")
        btn_bayar.setOnClickListener {
            val bayar = input_bayar.text.toString().toInt()
            val txtBarang = "${getString(R.string.nama_barang)} : $barang"
            val txtjumlah = "${getString(R.string.jumlah)} $jumlah"
            val txtHarga = "${getString(R.string.harga)} Rp$harga"
            val txtTotal = "${getString(R.string.total)} Rp$jumlahHarga"
            val txtKembalian = "${getString(R.string.kembalian)} Rp${bayar - jumlahHarga}"

            if (bayar < jumlahHarga){
                Toast.makeText(requireContext(), "Uang bayar kurang", Toast.LENGTH_SHORT).show()
                input_bayar.setText("")
            }else{
                dismiss()
                requireActivity().card_struk.visibility = View.VISIBLE
                requireActivity().tv_barang.text = txtBarang
                requireActivity().tv_jumlah.text = txtjumlah
                requireActivity().tv_harga.text = txtHarga
                requireActivity().tv_total.text = txtTotal
                requireActivity().tv_kembalian.text = txtKembalian
            }
        }
    }

}