package ikhwan.binar.chapterempat.recyclerview.latihanlima

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.item_lima.view.*

class LimaAdapter(val listApp : ArrayList<Aplikasi>)  : RecyclerView.Adapter<LimaAdapter.ViewHolder>(){
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_lima, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listApp[position]

        holder.itemView.apply {
            img_item_photo.setImageResource(data.img)
            tv_nama.text = data.nama
            tv_pt.text = data.pt
            tv_kategori.text = data.kat
            tv_rate.text = data.rate.toString()
            tv_ukuran.text = data.ukuran
            tv_download.text = data.jumlah
        }
    }

    override fun getItemCount(): Int {
        return listApp.size
    }


}