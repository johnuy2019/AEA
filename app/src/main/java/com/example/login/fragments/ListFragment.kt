package com.example.login.fragments

import RecyclerViewAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.Anime
import com.example.login.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: View= inflater.inflate(R.layout.fragment_list,container, false)
        // Inflate the layout for this fragment
        var llistat : MutableList<Anime> = ArrayList()
        var recyclerView: RecyclerView = v.findViewById(R.id.recyclerLlistat);
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter : RecyclerViewAdapter = RecyclerViewAdapter(llistat, context);
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        return inflater.inflate(R.layout.fragment_list, container, false)
    }
}