package com.example.lab6menufragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.lab6menufragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null){
            replaceFragment(FirstFragment())
        }

        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.menu1 -> replaceFragment(FirstFragment())
                R.id.menu2 -> replaceFragment(SecondFragment())
                R.id.menu3 -> replaceFragment(ThirdFragment())
                R.id.menu4 -> replaceFragment(ProfileFrangment())
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.myoption_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.op_menu1 -> replaceFragment(FirstFragment())
            R.id.op_menu2 -> replaceFragment(SecondFragment())
            R.id.op_menu3 -> replaceFragment(ThirdFragment())
        }
        return super.onOptionsItemSelected(item)
    }
    private fun replaceFragment(someFragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,someFragment)
        fragmentTransaction.commit()
    }
}