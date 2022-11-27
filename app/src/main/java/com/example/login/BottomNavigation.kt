package com.example.login

import DB.AnimeDBHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.example.login.fragments.FormFragment
import com.example.login.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity() {

    val dbHelper = AnimeDBHelper.DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        dbHelper.insertAnime(Anime("ttile", "winter", 2010.toInt(),"genre"));

        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_list -> {
                    loadFragment(ListFragment())
                    true
                }
                R.id.nav_form -> {
                    loadFragment(FormFragment())
                    true
                }
                else -> {false}
            }
        }
    }

    companion object{
        lateinit var dbHelper : AnimeDBHelper.DBHelper;
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }
}