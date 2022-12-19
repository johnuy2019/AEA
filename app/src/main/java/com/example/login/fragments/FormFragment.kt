package com.example.login.fragments

import android.content.Intent
import com.example.login.DB.AnimeDBHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.login.Anime
import com.example.login.BottomNavigation
import com.example.login.BottomNavigation.Companion.dbHelper
import com.example.login.R
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment(dbHelper: AnimeDBHelper.DBHelper) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_form, container, false)

        val txtTitle: EditText = v.findViewById(R.id.txtTitle)
        val txtSeason: EditText = v.findViewById(R.id.txtSeason)
        val txtGenre: EditText = v.findViewById(R.id.txtGenre)
        val btnNewForm: Button = v.findViewById(R.id.btnNewForm)

        btnNewForm.setOnClickListener {
            if((txtTitle.getText().isNotEmpty() || txtTitle.getText().isNotBlank()) && (txtSeason.getText().isNotEmpty() || txtSeason.getText().isNotBlank()) && (txtGenre.getText().isNotEmpty() || txtGenre.getText().isNotBlank())){
                dbHelper.insertAnime(Anime(txtTitle.text.toString(), txtSeason.text.toString(),txtGenre.text.toString()));
                Toast.makeText(context, "New anime in the list.", Toast.LENGTH_SHORT).show()
            }
        }
        return v;
    }
}
