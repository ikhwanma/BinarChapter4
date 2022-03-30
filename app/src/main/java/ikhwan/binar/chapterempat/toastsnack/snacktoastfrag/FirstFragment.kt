package ikhwan.binar.chapterempat.toastsnack.snacktoastfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import ikhwan.binar.chapterempat.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_toast.setOnClickListener {
            Toast.makeText(context, "Ini toast fragment", Toast.LENGTH_SHORT).show()
        }
        btn_snack.setOnClickListener {
            Snackbar.make(it, "Go to next page?", Snackbar.LENGTH_INDEFINITE).setAction("Go"){
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
            }.show()
        }
    }

}