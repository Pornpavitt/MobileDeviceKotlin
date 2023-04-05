package com.example.lab7recyclerviewdialog2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab7recyclerviewdialog2022.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var studentList = arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Set RecyclerView
        studentData()
        binding.recylerView.adapter = StudentAdapter(this.studentList,applicationContext)
        binding.recylerView.layoutManager = LinearLayoutManager(applicationContext)
        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.recylerView.addItemDecoration(itemDecor)

        //Click Add Student
        binding.btnAddstudent.setOnClickListener{
            val mDailogView = LayoutInflater.from(
                this).inflate(R.layout.add_dialog_layout,null)
            val myBuilder = AlertDialog.Builder(this)
            myBuilder.setView(mDailogView)

            //Save Button
            myBuilder.setPositiveButton("Save"){dialog,which ->
                val id = mDailogView.findViewById(R.id.edtId) as TextInputEditText
                val name = mDailogView.findViewById(R.id.edtName) as TextInputEditText
                val age = mDailogView.findViewById(R.id.edtAge) as TextInputEditText
                studentList.add(
                    Student(id.text.toString(),name.text.toString(),age.text.toString().toInt())
                )
                binding.recylerView.adapter?.notifyDataSetChanged()
                Toast.makeText(
                    applicationContext,
                    "The Student is Add Successfully",
                    Toast.LENGTH_LONG
                ).show()
            }
            //Cancel Button
            myBuilder.setNegativeButton("Cancel",){dailog,which ->
                dailog.dismiss()
            }
            myBuilder.show()
        }

    }
    fun studentData(){
        studentList.add(Student("No1","Aj.Monlica Wattana",29))
        studentList.add(Student("623020380-0","P.Qs",20))
        studentList.add(Student("623020408-4","P.Plang",20))
        studentList.add(Student("623020375-3","P.Peachs",20))
        studentList.add(Student("623020678-5","P.Eester",20))
        studentList.add(Student("623020373-7","P.Tuiz" ,20))
    }
}