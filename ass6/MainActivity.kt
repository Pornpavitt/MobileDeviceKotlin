package com.example.ass06menufragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.ass06menufragment.FirstFragment
import com.example.ass06menufragment.R
import com.example.ass06menufragment.SecondFragment
import com.example.ass06menufragment.ThirdFragment
import com.example.ass06menufragment.databinding.ActivityMainBinding
import com.example.ass06menufragment.databinding.FragmentThirdBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//Show First Fragment
        if (savedInstanceState==null){
            replaceFragment(FirstFragment())
        } }
    //Options Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.myoption_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    //Click on Options Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean { when
                                                                          (item.itemId) {
        R.id.op_menu1 -> replaceFragment(SecondFragment())
        R.id.op_menu2 -> replaceFragment(ThirdFragment()) }
        return super.onOptionsItemSelected(item)
    }
    private fun replaceFragment(someFragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,someFragment)
        fragmentTransaction.commit()
    }
}