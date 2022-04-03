package ikhwan.binar.chapterempat.codingexercisesatu

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.btn_register


class LoginFragment : Fragment() {

    private lateinit var sharedPreferencesRegister: SharedPreferences
    private lateinit var sharedPreferencesLogin: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferencesLogin = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        sharedPreferencesRegister = requireActivity().getSharedPreferences("register", Context.MODE_PRIVATE)

        val no = sharedPreferencesRegister.getString("hp", "")
        val pass = sharedPreferencesRegister.getString("pass", "")
        val nama = sharedPreferencesRegister.getString("nama", "")

        if (sharedPreferencesLogin.contains("nama")){
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
        }

        btn_register.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        btn_login.setOnClickListener {
            val getNo = input_no.text.toString()
            val getPass = input_pass.text.toString()

            if (getNo == no && getPass == pass){
                sharedPreferencesLogin.edit().putString("nama", nama).apply()
                it.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }else{
                Toast.makeText(requireContext(), "No/Pass salah", Toast.LENGTH_SHORT).show()
            }

        }
    }

}