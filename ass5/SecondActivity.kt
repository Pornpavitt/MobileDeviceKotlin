package com.example.ass05intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ass05intent.databinding.ActivitySecondBinding
class SecondActivity : AppCompatActivity() {
    private lateinit var bindingTwo : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        bindingTwo = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingTwo.root)
        var data = intent.extras
        var newEmp:Employee? = data?.getParcelable("EmpData")
        bindingTwo.Ename.text = "Employee Name : ${newEmp?.name}"
        bindingTwo.gender.text = "Gender : ${newEmp?.gender}"
        bindingTwo.mail.text = "Email : ${newEmp?.Email}"
        bindingTwo.salary.text = "Salary : ${newEmp?.Salary}"
    }
    fun onClickClose(view: View){
        finish()
    }
}