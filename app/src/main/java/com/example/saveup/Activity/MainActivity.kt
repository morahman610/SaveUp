package com.example.saveup.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.saveup.Adapter.budgetSpinnerAdapter
import com.example.saveup.Model.Budget
import com.example.saveup.R
import com.example.saveup.ViewModel.BudgetViewModel

class MainActivity : AppCompatActivity() {

    var number : String? = ""
    private lateinit var budgetDropDown : Spinner
    private lateinit var budgetViewModel: BudgetViewModel
    private lateinit var allBudgetNames: LiveData<List<String>>
    private lateinit var concatinatedText : TextView
    private lateinit var budgetSelected : Budget

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupUI()
    }

    private fun setupUI() {
        budgetDropDown = findViewById(R.id.budgetDropDown)
        concatinatedText = findViewById(R.id.text_field)


        budgetViewModel = ViewModelProviders.of(this).get(BudgetViewModel::class.java)
        budgetViewModel.getBudgets().observe(this, Observer { budgets ->
            budgetDropDown.adapter = budgetSpinnerAdapter(this,budgets)

            budgetDropDown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    budgetSelected = budgets[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        })


    }

    fun addBudgetIntent(view: View) {

        val intent = Intent(this, AddNewBudgetActivity::class.java )
        startActivity(intent)
    }

    fun concatText(view: View) {


        when(view.id) {
            R.id.buttonOne -> {
                number += "1"
                concatinatedText.setText(number)
            }
            R.id.buttonTwo -> {
                number += "2"
                concatinatedText.setText(number)
            }
            R.id.buttonThree -> {
                number += "3"
                concatinatedText.setText(number)
            }
            R.id.buttonFour -> {
                number += "4"
                concatinatedText.setText(number)
            }
            R.id.buttonFive -> {
                number += "5"
                concatinatedText.setText(number)
            }
            R.id.buttonSix -> {
                number += "6"
                concatinatedText.setText(number)
            }
            R.id.buttonSeven -> {
                number += "7"
                concatinatedText.setText(number)
            }
            R.id.buttonEight -> {
                number += "8"
                concatinatedText.setText(number)
            }
            R.id.buttonNine -> {
                number += "9"
                concatinatedText.setText(number)
            }
            R.id.buttonZero -> {
                number += "Zero"
                concatinatedText.setText(number)
            }
            R.id.buttonDecimal -> {
                number += "."
                concatinatedText.setText(number)
            }
            R.id.buttonClear -> {
                number = ""
                concatinatedText.setText(number)
            }
        }
    }

    fun amountSubmitOnClick(view: View) {
        budgetSelected.budgetSpending = concatinatedText.text.toString().toInt()



        budgetViewModel.updateBudget(budgetSelected)
    }
}
