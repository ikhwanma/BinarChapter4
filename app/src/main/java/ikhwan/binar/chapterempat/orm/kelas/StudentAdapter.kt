package ikhwan.binar.chapterempat.orm.kelas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ikhwan.binar.chapterempat.R
import ikhwan.binar.chapterempat.orm.kelas.room.Student
import kotlinx.android.synthetic.main.item_student.view.*

class StudentAdapter(val listStudent : List<Student>) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        val data = listStudent[position]
        val txtId = "ID : ${data.id}"
        val txtNama = "Nama : ${data.nama}"
        val txtEmail = "Email : ${data.email}"
        holder.itemView.apply {
            tv_id.text = txtId
            tv_nama.text = txtNama
            tv_email.text = txtEmail
        }
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

}