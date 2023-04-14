package com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { calculateTip() }

    }

    private fun calculateTip() {

        val stringInTextField = binding.editTextTextPersonName.text.toString()

        val cost = stringInTextField.toDoubleOrNull()

        val selectedOption = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedOption) {

            R.id.option_twenty_percent -> 0.20
            R.id.option_ten_percent -> 0.10
            else -> 0.05

        }

        if (cost == null){
            binding.tipResult.text = ""
            return
        }

        var tip = tipPercentage * cost!!

        binding.tipResult.text = tip.toString()


    }
}