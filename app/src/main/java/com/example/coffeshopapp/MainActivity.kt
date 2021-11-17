package com.example.coffeshopapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.coffeshopapp.fragments.CartFragment
import com.example.coffeshopapp.fragments.HomeFragment
import com.example.coffeshopapp.fragments.ProfileFragment
import com.example.coffeshopapp.models.CartModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

var curLocale : String = "ru"

val cart = CartModel()

class MainActivity : AppCompatActivity() {

     fun updateActivityWithLocale(language : String) {
         finish()
         startActivity(intent)
         val config = resources.configuration
         val locale = Locale(language)
         Locale.setDefault(locale)
         config.locale = locale
         resources.updateConfiguration(config, resources.displayMetrics)
         curLocale = language
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        homeFragment.initCart(cart)
        val cartFragment = CartFragment()
        cartFragment.initCart(cart)
        val profileFragment = ProfileFragment()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        makeCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_nav_home -> makeCurrentFragment(homeFragment)
                R.id.ic_nav_cart -> makeCurrentFragment(cartFragment)
                R.id.ic_nav_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

     private fun makeCurrentFragment(fragment: Fragment){
         supportFragmentManager.beginTransaction().apply {
             replace(R.id.fl_wrapper, fragment)
             commit()
         }
     }

}
