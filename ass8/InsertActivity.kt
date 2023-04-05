package com.example.ass8mysql

import Employee
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ass8mysql.databinding.ActivityInsertBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertActivity : AppCompatActivity() {
    private lateinit var bindingInsert : ActivityInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingInsert = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(bindingInsert.root)
        //Add Button
        bindingInsert.btnAdd.setOnClickListener{
            addEmployee()
        }

        //Reset Button
        bindingInsert.btnReset.setOnClickListener{
            resetEmployee()
        }
    }


    private fun addEmployee() {
        val api: EmployeeAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeAPI::class.java)

        // Use bindingInsert to access the radio buttons and get the selected gender
        var gender = ""
        if (bindingInsert.male.isChecked) {
            gender = "Male"
        }
        if (bindingInsert.female.isChecked) {
            gender = "Female"
        }

        api.insertStd(
            bindingInsert.edtName.text.toString(),
            gender,
            bindingInsert.edtEmail.text.toString(),
            bindingInsert.edtSalary.text.toString().toInt()
        ).enqueue(object : Callback<Employee>{
            override fun onResponse(
                call : Call<Employee>,
                response: retrofit2.Response<Employee>
            ){
                if(response.isSuccessful()){
                    Toast.makeText(applicationContext,"Successfully Inserted",
                        Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Inserted Failed",
                        Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call : Call<Employee>, t:Throwable){
                Toast.makeText(
                    applicationContext, "Error onFailure " + t.message,
                    Toast.LENGTH_LONG).show()
            }
        })
    }


    private fun resetEmployee(){
        bindingInsert.edtName.text?.clear()
        bindingInsert.edtGender.clearCheck() // Use edtGender instead of Gender
        bindingInsert.edtEmail.text?.clear()
        bindingInsert.edtSalary.text?.clear()
    }

}


