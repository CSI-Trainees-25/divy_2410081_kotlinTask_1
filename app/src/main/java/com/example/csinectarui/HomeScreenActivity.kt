package com.example.csinectarui


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class HomeScreenActivity : AppCompatActivity() {

    lateinit var navHomeIcon: ImageView
    lateinit var navExploreIcon: ImageView
    lateinit var navCartIcon: ImageView
    lateinit var navAccountIcon: ImageView
    lateinit var navFvrtIcon: ImageView

    lateinit var navHome:Button
    lateinit var navExplore:Button
    lateinit var navFvrt:Button
    lateinit var navCart:Button
    lateinit var navAccount:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )

        // Default screen
        loadFragment(HomeFragment())

        initializeViews()


        selectNavItem(navHome, HomeFragment())

        navHome.setOnClickListener {
            selectNavItem(it as Button, HomeFragment())
        }

        navExplore.setOnClickListener {
            selectNavItem(it as Button, ExploreFragment())
        }

        navAccount.setOnClickListener {
            selectNavItem(it as Button, AccountFragment())
        }

        navFvrt.setOnClickListener {
            selectNavItem(it as Button, FavouriteFragment())
        }
        navCart.setOnClickListener {
            selectNavItem(it as Button, CardFragment())
        }



    }


    private fun initializeViews(){

        navHome=findViewById<Button>(R.id.nav_home)
        navExplore=findViewById<Button>(R.id.nav_explore)
        navFvrt=findViewById<Button>(R.id.nav_fav)
        navAccount=findViewById<Button>(R.id.nav_account)
        navCart=findViewById<Button>(R.id.nav_cart)


        navHomeIcon=findViewById<ImageView>(R.id.nav_home_icon)
        navExploreIcon=findViewById<ImageView>(R.id.nav_explore_icon)
        navCartIcon=findViewById<ImageView>(R.id.nav_cart_icon)
        navFvrtIcon=findViewById<ImageView>(R.id.nav_fvrt_icon)
        navAccountIcon=findViewById<ImageView>(R.id.nav_account_icon)

    }

    private fun selectNavItem(selectedButton: Button , fragment: Fragment) {

        resetAllNavItems()

        selectedButton.isSelected=true
        selectedButton.setTextColor(ContextCompat.getColor(this, R.color.active_color))

        when (selectedButton.id) {
            R.id.nav_home -> {
                navHomeIcon.setColorFilter(ContextCompat.getColor(this, R.color.active_color))
                loadFragment(HomeFragment())
            }
            R.id.nav_explore -> {
                navExploreIcon.setColorFilter(ContextCompat.getColor(this, R.color.active_color))
                loadFragment(ExploreFragment())
            }
            R.id.nav_cart -> {
                navCartIcon.setColorFilter(ContextCompat.getColor(this, R.color.active_color))
                loadFragment(CardFragment())
            }
            R.id.nav_fav -> {
                navFvrtIcon.setColorFilter(ContextCompat.getColor(this, R.color.active_color))
                loadFragment(FavouriteFragment())
            }
            R.id.nav_account -> {
                navAccountIcon.setColorFilter(ContextCompat.getColor(this, R.color.active_color))
                loadFragment(AccountFragment())
            }
        }
    }


    private fun resetAllNavItems() {
        // Reset all buttons
        val buttons = listOf(navHome, navExplore, navCart, navFvrt, navAccount)
        buttons.forEach { button ->
            button.isSelected = false
            button.setTextColor(ContextCompat.getColor(this, R.color.inactive_color))
        }

        // Reset all icons
        val icons = listOf(navHomeIcon, navExploreIcon, navCartIcon, navFvrtIcon, navAccountIcon)
        icons.forEach { icon ->
            icon.clearColorFilter()
            icon.setColorFilter(ContextCompat.getColor(this, R.color.inactive_color))
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }
}
