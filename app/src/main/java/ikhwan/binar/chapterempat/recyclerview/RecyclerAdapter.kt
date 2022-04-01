package ikhwan.binar.chapterempat.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter(val listDataMhs: ArrayList<DataMhs>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listDataMhs[position]

        holder.itemView.apply {
            tv_nama.text = data.nama
            tv_umur.text = data.umur.toString()
            img_mhs.setImageResource(data.img)
        }
    }

    override fun getItemCount(): Int {
        return listDataMhs.size
    }
}