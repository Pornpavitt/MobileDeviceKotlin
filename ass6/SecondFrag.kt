package com.example.ass06menufragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ass06menufragment.databinding.ActivityMainBinding
import com.example.ass06menufragment.databinding.FragmentSecondBinding
class SecondFragment : Fragment() {
    private lateinit var bindingSecond : FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingSecond = FragmentSecondBinding.inflate(layoutInflater)
        bindingSecond.btnClickSecondFrag.setOnClickListener(){
            var fragment: Fragment? = null
            fragment = FirstFragment()
            replaceFragment(fragment)
        }
        return bindingSecond.root }
    fun replaceFragment(someFragment: Fragment) {
        var binding: ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val transaction =
            requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(binding.frameLayout.id, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
