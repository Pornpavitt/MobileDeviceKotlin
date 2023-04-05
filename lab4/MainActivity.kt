package com.example.lab4ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.lab4ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var subject :String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDropdown()
    }
    private fun showDropdown(){
        binding.autoCompleteTextview.setText("Select Subject")
        val sub = resources.getStringArray(R.array.subjectName_array)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_item,sub)
        binding.autoCompleteTextview.setAdapter(arrayAdapter)

        binding.autoCompleteTextview.setOnItemClickListener { parent, _, position, _ ->
            subject = parent.getItemAtPosition(position) as String
            //Show Toast
            Toast.makeText(applicationContext, subject, Toast.LENGTH_LONG).show()
        }
    }
    fun showTimePickerDailog(v: View){
        val newTimeFragment = TimePickerFragment()
        newTimeFragment.show(supportFragmentManager,"Time Picker")
    }
    fun showDetail(v: View){
        binding.textShow.text = "ID: ${binding.editTextId.text}\n" +
                "Name: ${binding.editTextName.text}\n" +
                "Subject: $subject\nTime: ${binding.textTime.text}"
    }
    fun reset(v: View){
        binding.editTextId.text?.clear()
        binding.editTextName.text?.clear()
        showDropdown()
        binding.autoCompleteTextview.clearFocus()
        binding.textTime.text="_ _:_ _"
        binding.textShow.text="Show Detail"
    }
}