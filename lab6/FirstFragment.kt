package com.example.lab6menufragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab6menufragment.databinding.ActivityMainBinding
import com.example.lab6menufragment.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var bindingFirst : FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFirst = FragmentFirstBinding.inflate(layoutInflater)
        bindingFirst.btnClickFirstFrag.setOnClickListener(){
            var fragment: Fragment? = null
            fragment = SecondFragment()
            replaceFragment(fragment)
        }
        return bindingFirst.root
    }
    fun replaceFragment(someFragment: Fragment){
        var binding: ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(binding.frameLayout.id,someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}