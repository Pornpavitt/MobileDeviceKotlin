package com.example.lab8mysql_queryinsert


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab8mysql_queryinsert.databinding.ActivityInsertBinding
import Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInsertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInsertBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            addStudent()
        }

        binding.btnReset.setOnClickListener {
            resetStudent()
        }
    }

    fun addStudent(){
        val api: StudentAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI:: class.java)

        api.insertStd(
            binding.edtId.text.toString(),
            binding.edtName.text.toString(),
            binding.edtAge.text.toString().toInt(),
        ).enqueue(object : Callback<Student> {
            override fun onResponse(call: Call<Student>, response: Response<Student>) {
                if(response.isSuccessful()){
                    Toast.makeText(applicationContext, "Insert Success", Toast.LENGTH_LONG).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext, "Insert Failed", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Student>, t: Throwable) {
                Toast.makeText(applicationContext, "Error onFailure", Toast.LENGTH_LONG).show()
            }

        })
    }
    fun resetStudent(){
        binding.edtId.text?.clear()
        binding.edtName.text?.clear()
        binding.edtAge.text?.clear()
    }
}