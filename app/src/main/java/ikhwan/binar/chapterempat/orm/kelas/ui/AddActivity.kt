package ikhwan.binar.chapterempat.orm.kelas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ikhwan.binar.chapterempat.R
import ikhwan.binar.chapterempat.orm.kelas.room.Student
import ikhwan.binar.chapterempat.orm.kelas.room.StudentDatabase
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddActivity : AppCompatActivity() {

    private var studentDatabase : StudentDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        studentDatabase = StudentDatabase.getInstance(this)

        btn_save.setOnClickListener {
            val nama = input_nama.text.toString()
            val email = input_email.text.toString()
            val student = Student(null, nama, email)

            GlobalScope.async {
                val hasil = studentDatabase?.studentDao()?.insertStudent(student)
                runOnUiThread {
                    if (hasil != 0.toLong()){
                        Toast.makeText(this@AddActivity, "Sukses", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@AddActivity, MainRoomActivity::class.java))
                    }else{
                        Toast.makeText(this@AddActivity, "Gagal", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}