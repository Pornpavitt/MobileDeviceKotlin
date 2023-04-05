package com.example.ass8mysql

import Employee
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ass8mysql.databinding.EmpItemLayoutBinding

class EmployeeAdptor (val employList: ArrayList<Employee>?, val context: Context): RecyclerView.Adapter<EmployeeAdptor.ViewHolder>(){
    class ViewHolder(view: View, val binding: EmpItemLayoutBinding): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EmpItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root, binding)
    }

    override fun getItemCount(): Int {
        return employList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding

        binding.txtName.text = "Name: " + employList!![position].emp_name
        binding.txtGender.text = "Gender: " + employList!![position].emp_gender
        binding.txtEmail.text = "Email: " + employList!![position].emp_email.toString()
        binding.txtSalary.text = "Salary: " + employList!![position].emp_salary.toString()
    }
}