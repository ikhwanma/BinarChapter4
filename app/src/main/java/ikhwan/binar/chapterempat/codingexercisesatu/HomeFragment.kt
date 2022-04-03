package ikhwan.binar.chapterempat.codingexercisesatu

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("login", Context.MODE_PRIVATE)

        val txtNama = "Halo, ${sharedPreferences.getString("nama", "")}"
        tv_nama.text = txtNama

        btn_logout.setOnClickListener {
            AlertDialog.Builder(requireContext()).setTitle("Logout").setMessage("Yakin?")
                .setPositiveButton("Ya"){ p0, p1 ->
                    sharedPreferences.edit().clear().apply()
                    it.findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                }.setNegativeButton("Tidak"){ p0, p1 ->
                }.show()

        }
    }


}