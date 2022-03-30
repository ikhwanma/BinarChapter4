package ikhwan.binar.chapterempat.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.fragment_contoh_dialog.*


class ContohDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contoh_dialog, container, false)
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_proses.setOnClickListener {
            val umur = input_umur.text.toString()
            Toast.makeText(context, "Umur anda : $umur", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}