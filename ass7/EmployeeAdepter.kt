package com.example.ass07

import Employee
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ass07.databinding.AddEmployeeLayoutBinding
import com.example.ass07.databinding.EmItemLayoutBinding


class EmployeeAdepter(val employeelistList: ArrayList<Employee>?, val context: Context):
    RecyclerView.Adapter<EmployeeAdepter.ViewHolder>() {
    class ViewHolder(view: View, val binding: EmItemLayoutBinding) :
        RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EmItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root, binding)
    }

    override fun getItemCount(): Int {
        return employeelistList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        binding.txtName.text = "Name: ${employeelistList!! [position].name}"
        binding.txtGender.text = "Gender: ${employeelistList!! [position].gender}"
        binding.txtEmail.text = "E-mail: ${employeelistList!! [position].e_mail}"
        binding.txtSalary.text = "Salary : ${employeelistList!! [position].salary.toString()}"
    }
}