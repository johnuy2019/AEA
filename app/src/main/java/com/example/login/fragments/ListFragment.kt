package com.example.login.fragments

import com.example.login.DB.AnimeDBHelper
import RecyclerViewAdapter
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.Anime
import com.example.login.BottomNavigation
import com.example.login.DB.AnimeContract
import com.example.login.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment(dbHelper: AnimeDBHelper.DBHelper) : Fragment() {
    val dbHelper = dbHelper;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: View= inflater.inflate(R.layout.fragment_list,container, false)
        // Inflate the layout for this fragment
        val btnPurgeDb: FloatingActionButton = v.findViewById(R.id.btnPurgeList);
        var recyclerView: RecyclerView = v.findViewById(R.id.recyclerLlistat);
        var llistat :ArrayList<Anime> = dbHelper.selectAnime();

        callRecycler(recyclerView,llistat);

        btnPurgeDb.setOnClickListener {
            purgeDatabase(llistat, recyclerView)
        }

        return v;
    }

    fun callRecycler(recyclerView:RecyclerView,llistat:ArrayList<Anime>){
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter: RecyclerViewAdapter = RecyclerViewAdapter(llistat, context);
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

    }

    fun purgeDatabase(llistat: ArrayList<Anime>, recyclerView: RecyclerView){
        if(!llistat.isEmpty()){

            dbHelper.onDelete();
            var llistat :ArrayList<Anime> = dbHelper.selectAnime();

            val builder = AlertDialog.Builder(context)
            builder.setMessage("Are you sure you want to purge the list?")
                .setPositiveButton("Yes!",
                    DialogInterface.OnClickListener { dialog, id ->
                        // START THE GAME!
                        dbHelper.onDelete();
                        Toast.makeText(context, "All users are deleted.", Toast.LENGTH_SHORT).show()
                        callRecycler(recyclerView,llistat);
                    })
                .setNegativeButton("No!",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                        Toast.makeText(context, "Purging the list is canceled.", Toast.LENGTH_SHORT).show()
                    })
            // Create the AlertDialog object and return it
            builder.create().show()
        } else {
            Toast.makeText(context, "List is empty.", Toast.LENGTH_SHORT).show()
        }
    }


}
