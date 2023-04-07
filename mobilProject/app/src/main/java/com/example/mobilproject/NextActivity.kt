package com.example.mobilproject

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilproject.databinding.ActivityMainBinding
import com.example.mobilproject.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences("com.example.mobilproject", MODE_PRIVATE)


        val kaloriPreferences = sharedPreferences.getString("kalori", "0")

        binding.resultText.text = kaloriPreferences


    }

    fun solutionAction(view: View) {
        val name=binding.userNameText.text.toString()

        val weight = binding.weightText.text.toString().toDoubleOrNull()
        val timeh = binding.timeText.text.toString().toDoubleOrNull()
        val meet = binding.meetText.text.toString().toDoubleOrNull()

        if (weight == null || timeh == null || meet == null) {
            binding.resultText.text = "Lütfen geçerli sayısal değerler girin."
        } else {


            val total = (weight * 0.4536) * meet * timeh
            binding.resultText.text = String.format(" %.2f kcl kalori yaktınız  ", total)+name

           // binding.resultText.text = "${total} kcl kalori yaktınız"

            sharedPreferences.edit().putString("kalori",name+ String.format(" %.2f kcl kalori yaktınız... ", total) ).apply()
        }
    }


}