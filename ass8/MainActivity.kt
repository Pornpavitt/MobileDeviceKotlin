package com.example.ass8mysql

import Employee
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ass8mysql.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var studentList = arrayListOf<Employee>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = EmployeeAdptor(this.studentList, applicationContext)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(binding.recyclerView.getContext(), DividerItemDecoration.VERTICAL)
        )

        binding.btnEmployee.setOnClickListener {
            val intent = Intent(applicationContext, InsertActivity::class.java)
            startActivity(intent)
        }

    }

    override  fun onResume() {
        super.onResume()
        callStudentData()
    }

    private fun callStudentData() {
        studentList.clear();
        val serv: EmployeeAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeAPI::class.java)
        serv.retrieveStudent()
            .enqueue(object : Callback<List<Employee>> {
                override fun onResponse(
                    call: Call<List<Employee>>,
                    response: Response<List<Employee>>
                ) {
                    response.body()?.forEach {
                        studentList.add(Employee(it.emp_name,it.emp_gender,it.emp_email,it.emp_salary))
                    }
                    binding.recyclerView.adapter = EmployeeAdptor(studentList, applicationContext)
                    binding.txtList.text = "Student List : " + studentList.size.toString()
                }

                override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                    Toast.makeText(applicationContext,"Error onFailure "+ t.message, Toast.LENGTH_LONG).show()
                }
            })
    }
}