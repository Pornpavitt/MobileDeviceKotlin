package com.example.lab05internet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import com.example.lab05internet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //When Click Register Button
        binding.btnShowDetail.setOnClickListener{
           var hobby_str:String = " "
           if(binding.cbReading.isChecked){
               hobby_str += "" + binding.cbReading.text;
           }
            if(binding.cbWatching.isChecked){
                hobby_str += "" + binding.cbWatching.text;
            }
            if(binding.cbCooking.isChecked){
                hobby_str += "" + binding.cbCooking.text;
            }
            if(binding.cbGame.isChecked){
                hobby_str += "" + binding.cbGame.text;
            }
            var hobby_new = if(hobby_str.isNotEmpty()) hobby_str else "No Hobby."

            var intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("stdData",Student(binding.edtID.text.toString(),
                binding.edtName.text.toString(),
                binding.edtRank.text.toString(),
                binding.edtAge.text.toString().toInt(),hobby_new))
            startActivity(intent)
        }
    }
}