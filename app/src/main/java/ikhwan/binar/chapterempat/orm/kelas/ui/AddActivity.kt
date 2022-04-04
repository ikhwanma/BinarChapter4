package ikhwan.binar.chapterempat.orm.kelas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ikhwan.binar.chapterempat.R
import ikhwan.binar.chapterempat.orm.kelas.Student
import ikhwan.binar.chapterempat.orm.kelas.room.StudentDatabase
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddActivity : AppCompatActivity() {

    private var studentDatabase: StudentDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        studentDatabase = StudentDatabase.getInstance(this)

        btn_save.setOnClickListener {
            val student = Student(
                null,
                input_nama.text.toString(),
                input_email.text.toString()
            )

            GlobalScope.async {
                val hasil = studentDatabase?.studentDao()?.insertStudent(student)
                runOnUiThread {
                    if(hasil != 0.toLong() ){
                        Toast.makeText(this@AddActivity,"Sukses menambahkan ${student.nama}",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@AddActivity,"Gagal menambahkan ${student.nama}",
                            Toast.LENGTH_LONG).show()
                    }
                    finish()
                }
            }
        }
    }
}