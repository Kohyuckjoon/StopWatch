package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.DialogCountdownPickerBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //CountDown Text Click
        binding.countdownTextView.setOnClickListener {
            showCountdownDialog()
        }


        //StartButton Click
        binding.startButton.setOnClickListener {

        }


        //PauseButton Click
        binding.pauseButton.setOnClickListener {

        }
    }

    private fun showCountdownDialog () {
        val dialogBinding = DialogCountdownPickerBinding.inflate(layoutInflater)
        val numberPicker = dialogBinding.numberPicker

        numberPicker.minValue = 1
        numberPicker.maxValue = 60
        numberPicker.value = 10

        AlertDialog.Builder(this)
            .setTitle("카운트 다운 설정")
            .setView(dialogBinding.root)
            .setNegativeButton("취소", null)
            .setPositiveButton("확인") {_, _->
                val selectedValue = numberPicker.value
                binding.countdownTextView.text = selectedValue.toString()
            }.show()
    }
}