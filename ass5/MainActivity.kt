package com.example.ass05intent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.ass05intent.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClickshowInformation(v: View) {
        var selectID: Int = binding.radioGroup.checkedRadioButtonId
        var radioButtonChecked: RadioButton = findViewById(selectID)
        var gd = radioButtonChecked.text.toString()
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("EmpData",Employee(binding.Editname.text.toString(),gd,binding.Email.text.toString(),
            binding.salary.text.toString().toInt() ))
        startActivity(intent)
    }
    fun reset(v:View) {
        binding.Editname.text?.clear()
        binding.Email.text?.clear()
        binding.salary.text?.clear()
        binding.radioGroup.clearCheck();
    }
}