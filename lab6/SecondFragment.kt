package com.example.lab6menufragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lab6menufragment.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private lateinit var bindingSecondFrag : FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingSecondFrag = FragmentSecondBinding.inflate(layoutInflater)
        bindingSecondFrag.btnClickSecondFrag.setOnClickListener{
            val toast = Toast.makeText(context,"Click on Seccond Fragment",Toast.LENGTH_SHORT)
            toast.show()
        }
        // Inflate the layout for this fragment
        return bindingSecondFrag.root
    }

}