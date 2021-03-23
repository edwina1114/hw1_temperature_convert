package com.example.hw1_temperature_convert

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.hw1_temperature_convert.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding  //ActivityMainBinding表示跟隨哪個layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DataBinding的必要條件 (相對於 setContentView)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //DataBinding的必要條件 (相對於 setContentView)

        binding.tempConvert.setOnClickListener {
            convert(it)
        }
    }

    private fun convert(view: View)
    {
        binding.apply {
            //var temp: Double ?= Double.parseDouble(tempInput.text)
            var temp: Double = tempInput.text.toString().toDouble()
            temp = (temp-32)*5/9
            answer.text = temp.toString()
        }
        //隱藏鍵盤
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


}
