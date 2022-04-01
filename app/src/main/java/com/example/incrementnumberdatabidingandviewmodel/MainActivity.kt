package com.example.incrementnumberdatabidingandviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.incrementnumberdatabidingandviewmodel.databinding.ActivityMainBinding
import com.example.incrementnumberdatabidingandviewmodel.viewmodel.IncrementViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:IncrementViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.increment.setOnClickListener {
            Log.d("Observer", viewModel.currentNumberValue.value.toString())
            viewModel.increment()
        }
    }

    override fun onResume() {
        super.onResume()
        //observe on the livedata and update the UI
        viewModel.currentNumberValue.observe(this, Observer {
            binding.value.text = it.toString()
        })
    }
}