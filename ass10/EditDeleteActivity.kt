package com.example.lab10sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lab10sqlite.databinding.ActivityEditDeleteBinding
import layout.DatabaseHelper
import layout.Student

class EditDeleteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditDeleteBinding
    private lateinit var dbHandler: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditDeleteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dbHandler = DatabaseHelper.getInstance(baseContext)
        val mID = intent.getStringExtra("mId")
        val mName = intent.getStringExtra("mName")
        val mAge = intent.getStringExtra("mAge")

        binding.edtId.setText(mID)
        binding.edtId.isEnabled = false
        binding.edtName.setText(mName)
        binding.edtAge.setText(mAge)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    fun saveStudent(v: View){
        var id = binding.edtId.text.toString()
        var name = binding.edtName.text.toString()
        var age = binding.edtAge.text.toString().toInt()
        var result = dbHandler.updateStudent(
            Student(
            id=id,
            name=name,
            age=age
        )
        )
        if(result > -1){
            Toast.makeText(applicationContext, "Updated success", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "Updated failure", Toast.LENGTH_LONG).show()
        }
        finish()
    }
    fun deleteStudent(v:View){
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.apply {
            setTitle("Warning")
            setMessage("Do you want to delete the student?")
            setNegativeButton("Yes"){_,_->
                val id = binding.edtId.text.toString()
                Toast.makeText(applicationContext,id.toString()+" Deleted",Toast.LENGTH_SHORT).show()
                val result = dbHandler.deleteStudent(id)
                if (result > -1){
                    Toast.makeText(applicationContext,"Delete successfully",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext,"Delete Failure",Toast.LENGTH_SHORT).show()
                }
                finish()
            }
            setPositiveButton("No"){dialog,_->dialog.cancel()}
            show()
        }
    }


}