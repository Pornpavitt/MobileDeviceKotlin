package com.example.ass04ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.ass04ui.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var Gender: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun showDatePickerDialog(v: View) {
        val newDateFragment = DatePickerFragment()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }
    fun showDetail(v: View) {
        var selectID: Int = binding.radioGroup.checkedRadioButtonId
        var radioButtonChecked: RadioButton = findViewById(selectID)
        binding.textShow.text =
            "Username : ${binding.editUsername.text}\n" +
                    "Password: ${binding.editPassword.text}\n" +
                    "Gender: ${radioButtonChecked.text}\n" +
                    "Email: ${binding.editEmail.text}\n" +
                    "Birthday: ${binding.textDate.text}"
    }
    fun reset(v: View) {
        binding.editUsername.text?.clear()
        binding.editPassword.text?.clear()
        binding.editEmail.text?.clear()
        binding.radioGroup.clearCheck()
        binding.textDate.text = "mm / dd / yy"
        binding.textShow.text = "Show Information"
    }
}