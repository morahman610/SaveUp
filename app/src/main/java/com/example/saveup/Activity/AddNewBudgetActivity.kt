package com.example.saveup.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.saveup.Model.Budget
import com.example.saveup.R
import com.example.saveup.ViewModel.BudgetViewModel
import kotlinx.android.synthetic.main.activity_add_new_budget.*

class AddNewBudgetActivity : AppCompatActivity() {

    private lateinit var budgetViewModel: BudgetViewModel
    private lateinit var newBudget : Budget

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_budget)

        budgetViewModel = ViewModelProviders.of(this).get(BudgetViewModel::class.java)
    }

    fun addBudget(view: View) {

        val newBudgetName = newBudgetNameTxt.text.toString()
        val newBudgetMaxSpending = newBudgetMaxSpendingTxt.text.toString().toInt()
        newBudget = Budget(newBudgetName,0, newBudgetMaxSpending)

        budgetViewModel.addBudget(newBudget)
    }
}
