package ikhwan.binar.chapterempat.orm.kelas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ikhwan.binar.chapterempat.R
import ikhwan.binar.chapterempat.orm.kelas.StudentAdapter
import ikhwan.binar.chapterempat.orm.kelas.room.StudentDatabase
import kotlinx.android.synthetic.main.activity_main_room.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainRoomActivity : AppCompatActivity() {

    private var studentDatabase: StudentDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)

        studentDatabase = StudentDatabase.getInstance(this)

        getData()

        fab_add.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    private fun getData() {
        rv_student.layoutManager = LinearLayoutManager(this)
        GlobalScope.async {
            val listStudent = studentDatabase?.studentDao()?.getAllStudent()

            runOnUiThread {
                val adapter = StudentAdapter(listStudent!!)
                rv_student.adapter = adapter
            }
        }
    }
}