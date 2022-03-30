package ikhwan.binar.chapterempat.toastsnack.latihandua

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.fragment_first_dua.*

class FirstDuaFragment : Fragment() {

    private lateinit var nama: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_welcome.setOnClickListener {
            nama = input_nama.text.toString()
            Toast.makeText(context, "Welcome $nama!", Toast.LENGTH_LONG).show()
        }
        btn_navigation.setOnClickListener {
            nama = input_nama.text.toString()
            Snackbar.make(it, "Go to next page, $nama?", Snackbar.LENGTH_INDEFINITE)
                .setAction("Go") {
                    Navigation.findNavController(view)
                        .navigate(R.id.action_firstDuaFragment_to_secondDuaFragment)
                }.show()
        }
    }

}