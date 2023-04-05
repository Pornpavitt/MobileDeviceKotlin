package com.example.lab6menufragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lab6menufragment.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var bindingThirdFragment: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingThirdFragment = FragmentThirdBinding.inflate(layoutInflater)
        bindingThirdFragment.btnClickThridFrag.setOnClickListener(){
            val toast = Toast.makeText(context,"Click on Fragment Three",Toast.LENGTH_SHORT)
            toast.show()
        }
        // Inflate the layout for this fragment
        return bindingThirdFragment.root
    }
}