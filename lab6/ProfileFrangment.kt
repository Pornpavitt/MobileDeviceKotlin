package com.example.lab6menufragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lab6menufragment.databinding.ActivityMainBinding
import com.example.lab6menufragment.databinding.FragmentProfileFrangmentBinding
import com.example.lab6menufragment.databinding.FragmentThirdBinding


class ProfileFrangment : Fragment() {
    private lateinit var bindingProfileFrag : FragmentProfileFrangmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingProfileFrag = FragmentProfileFrangmentBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return bindingProfileFrag.root
    }


}