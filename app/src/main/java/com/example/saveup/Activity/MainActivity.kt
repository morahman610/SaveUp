package com.example.saveup.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.saveup.Model.Budget
import com.example.saveup.R
import com.example.saveup.ViewModel.BudgetViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number : String? = ""
    private lateinit var budgetDropDown : Spinner
    private lateinit var budgetViewModel: BudgetViewModel
    private lateinit var allBudgetNames: LiveData<List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupUI()
    }

    private fun setupUI() {
        budgetDropDown = findViewById(R.id.budgetDropDown)
        budgetViewModel = ViewModelProviders.of(this).get(BudgetViewModel::class.java)
        budgetViewModel.getAllBudgetNames().observe(this, Observer { budgetNames ->
            budgetDropDown.adapter = ArrayAdapter<String>(this,
            R.layout.support_simple_spinner_dropdown_item, budgetNames)
        })
    }

    fun addBudgetIntent(view: View) {

        val intent = Intent(this, AddNewBudgetActivity::class.java )
        startActivity(intent)
    }

    fun concatText(view: View) {

        var text : TextView = findViewById(R.id.text_field)

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

    fun amountSubmitOnClick(view: View) {

    }
}
