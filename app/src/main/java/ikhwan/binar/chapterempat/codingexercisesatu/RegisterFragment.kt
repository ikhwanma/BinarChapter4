package ikhwan.binar.chapterempat.codingexercisesatu

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("register", Context.MODE_PRIVATE)

        btn_register.setOnClickListener {
            val nama = input_nama.text.toString()
            val email = input_email.text.toString()
            val hp = input_no.text.toString()
            val pass = input_pass.text.toString()
            sharedPreferences.edit().putString("nama", nama).putString("email", email).putString("hp", hp).putString("pass", pass).apply()
            it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}