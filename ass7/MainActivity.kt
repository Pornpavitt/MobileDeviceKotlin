package com.example.ass07

import Employee
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ass07.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var radioGroup: RadioGroup
    var employeelist = arrayListOf<Employee>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        employeeData()
        binding.recylerView.adapter = EmployeeAdepter(this.employeelist, applicationContext)
        binding.recylerView.layoutManager = LinearLayoutManager(applicationContext)
        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.recylerView.addItemDecoration(itemDecor)

        binding.btnAddstudent.setOnClickListener{
            val mDialogView = LayoutInflater.from( this).inflate(R.layout.add_employee_layout,null)
            val myBuilder = AlertDialog.Builder(this) //.R.style.CustomAlertDialog
            myBuilder.setView(mDialogView)
            ///Save Button
            myBuilder.setPositiveButton("Add Employee") { dialog, which ->
                val name = mDialogView.findViewById(R.id.edtName) as TextInputEditText
                var genders = ""
                val gender = mDialogView.findViewById(R.id.radioGroupGender) as RadioGroup
                if (gender.textAlignment == 0) {
                    genders += "Male"
                }
                if (gender.textAlignment == 1) {
                    genders += "Female"
                }
                val email = mDialogView.findViewById(R.id.edtEmail) as TextInputEditText
                val salary = mDialogView.findViewById(R.id.edtSalary) as TextInputEditText
                employeelist.add(
                    Employee(name.text.toString(), genders, email.text.toString(), salary.text.toString().toInt()))
                binding.recylerView.adapter?.notifyDataSetChanged()
                Toast.makeText(
                    applicationContext,
                    "The Employee is added successfully",
                    Toast.LENGTH_LONG
                ).show()
            }
            ///Cancel Button
            myBuilder.setNegativeButton( "Cancel") { dialog, which ->
                dialog.dismiss()
            }
            myBuilder.show() }
    }
    fun employeeData() {
        employeelist.add(Employee("Gojo Satoru","male","ruietenkai@gmail.com",3210051))
    }
}