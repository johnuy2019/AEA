package com.example.login

import DB.AnimeDBHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.example.login.fragments.FormFragment
import com.example.login.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)
        val dbHelper = AnimeDBHelper.DBHelper(this)

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
        dbHelper.insertAnime(Anime("title", "winter_2000","genre"));
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    companion object {
        lateinit var dbHelper: AnimeDBHelper.DBHelper;
    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }
}
