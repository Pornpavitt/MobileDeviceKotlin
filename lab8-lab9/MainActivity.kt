package com.example.lab8mysql_queryinsert

import Student
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab8mysql_queryinsert.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var studentList = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Link To ReView
        binding.recyclerView.adapter = StudentsAdapter(this.studentList,applicationContext)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(binding.recyclerView.getContext(),
                DividerItemDecoration.VERTICAL)
        )
        binding.btnAddStudent.setOnClickListener{
            val intent = Intent(applicationContext,InsertActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume(){
        super.onResume()
        callStudentData()
    }
    private fun callStudentData(){
        studentList.clear();
        val serv : StudentAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI::class.java)
        serv.retrieveStudent()
            .enqueue(object : Callback<List<Student>> {
                override fun onResponse(call: Call<List<Student>>,
                                        response: Response<List<Student>>){
                    response.body()?.forEach{
                        studentList.add(Student(it.std_id,it.std_name,it.std_age))
                    }
                    //Set Data 2 review
                    binding.recyclerView.adapter = StudentsAdapter(studentList,applicationContext)
                    binding.txtList.text = "Student List: "+studentList.size.toString()
                }

                override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                    Toast.makeText(applicationContext,"Error onFialure"+ t.message,
                        Toast.LENGTH_LONG).show()
                }
            })
    }
}