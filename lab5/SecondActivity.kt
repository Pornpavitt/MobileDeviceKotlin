package com.example.lab05internet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab05internet.databinding.ActivityMainBinding
import com.example.lab05internet.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding2nd: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding2nd = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding2nd.root)

        //Get Data From Parcelable
        var data = intent.extras
        var newSTD:Student? =data?.getParcelable("stdData")

        //ShowData
        binding2nd.txtID.text = "Student ID: ${newSTD?.id} "
        binding2nd.txtName.text = "Student Name: ${newSTD?.name} "
        binding2nd.txtRank.text = "Student Rank : ${newSTD?.rank}"
        binding2nd.txtAge.text = "Student Age: ${newSTD?.age} "
        binding2nd.txtHobby.text = "Student hobby: ${newSTD?.hobby} "

        //CloseButton
        binding2nd.btnClose.setOnClickListener{
            finish()
        }
    }
}