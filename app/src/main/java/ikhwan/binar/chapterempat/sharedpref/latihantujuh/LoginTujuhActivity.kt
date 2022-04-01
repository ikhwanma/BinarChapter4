package ikhwan.binar.chapterempat.sharedpref.latihantujuh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.activity_login_tujuh.*

class LoginTujuhActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_tujuh)

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        if (sharedPreferences.contains(USERNAME)){
            startActivity(Intent(this, HomeTujuhActivity::class.java))
            finish()
        }else{
            login()
        }
    }

    private fun login() {
        btn_login.setOnClickListener {
            val uname = input_uname.text.toString()
            val password = input_pass.text.toString()

            if(uname == "ikhwan" && password == "123456"){
                sharedPreferences.edit()
                    .putString(USERNAME, uname)
                    .putString(PASSWORD, password)
                    .apply()

                startActivity(Intent(this, HomeTujuhActivity::class.java))
                finish()
            }else{
                Snackbar.make(it, "Username/Password salah", Snackbar.LENGTH_LONG).setAction("Clear"){
                    input_uname.setText("")
                    input_pass.setText("")
                }.show()
            }
        }
    }

    companion object{
        const val PREF_NAME = "pref"
        const val USERNAME = "username"
        const val PASSWORD = "password"
    }
}