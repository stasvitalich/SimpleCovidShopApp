package com.example.covidshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.covidshop.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() { // Создаём main activity.

    lateinit var bindingClass: ActivityMainBinding


    override fun onCreate(s: Bundle?) { // Создаём первый цикл жизни Activity - onCreate/
        super.onCreate(s) // Это обязательная строка для onCreate
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.resultButton.setOnClickListener{
            if (bindingClass.editTextTextPersonName.text.toString().toInt() <= 90){
                bindingClass.positiveResultText.visibility = View.VISIBLE
                bindingClass.negativeResultText.visibility = View.INVISIBLE
                bindingClass.difference.visibility = View.INVISIBLE
            }else{
                bindingClass.negativeResultText.visibility = View.VISIBLE
                var difference = abs(90 - bindingClass.editTextTextPersonName.text.toString().toInt())
                bindingClass.difference.text = difference.toString()
                bindingClass.difference.visibility = View.VISIBLE
                bindingClass.positiveResultText.visibility = View.INVISIBLE
            }
        }
    }
}