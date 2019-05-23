package com.example.saveup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var number : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun concatText(view: View) {

        var text : EditText = findViewById(R.id.text_field)

        when(view.id) {
            R.id.buttonOne -> {
                number += "1"
                text.setText(number)
            }
            R.id.buttonTwo -> {
                number += "2"
                text.setText(number)
            }
            R.id.buttonThree -> {
                number += "3"
                text.setText(number)
            }
            R.id.buttonFour -> {
                number += "4"
                text.setText(number)
            }
            R.id.buttonFive -> {
                number += "5"
                text.setText(number)
            }
            R.id.buttonSix -> {
                number += "6"
                text.setText(number)
            }
            R.id.buttonSeven -> {
                number += "7"
                text.setText(number)
            }
            R.id.buttonEight -> {
                number += "8"
                text.setText(number)
            }
            R.id.buttonNine -> {
                number += "9"
                text.setText(number)
            }
            R.id.buttonZero -> {
                number += "Zero"
                text.setText(number)
            }
            R.id.buttonDecimal -> {
                number += "."
                text.setText(number)
            }
            R.id.buttonClear -> {
                number = ""
                text.setText(number)
            }
        }
    }
}
