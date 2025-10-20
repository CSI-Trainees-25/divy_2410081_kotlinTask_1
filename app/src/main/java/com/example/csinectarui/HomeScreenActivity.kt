package com.example.csinectarui


import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )

        // Default screen
        loadFragment(HomeFragment())

        // Bottom nav clicks
        val navHome = findViewById<Button>(R.id.nav_home)
        val navExplore = findViewById<Button>(R.id.nav_explore)
        val navAccount=findViewById<Button>(R.id.nav_account)
        val navFav=findViewById<Button>(R.id.nav_fav)
        val navCart=findViewById<Button>(R.id.nav_cart)


        navHome.setOnClickListener { loadFragment(HomeFragment()) }
        navExplore.setOnClickListener { loadFragment(ExploreFragment()) }
        navAccount.setOnClickListener { loadFragment(AccountFragment()) }
        navFav.setOnClickListener({loadFragment(FavouriteFragment())})
        navCart.setOnClickListener({loadFragment(CardFragment())})


    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }
}
