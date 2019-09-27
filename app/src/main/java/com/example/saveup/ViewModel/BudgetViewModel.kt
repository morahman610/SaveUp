package com.example.saveup.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.saveup.Model.AppDB
import com.example.saveup.Model.Budget
import com.example.saveup.Model.BudgetsRepository

class BudgetViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : BudgetsRepository
    private val allBudgets : LiveData<List<Budget>>

    init {

        val budgetDAO = AppDB.getDatabase(application).budgetDAO()
        repository = BudgetsRepository(budgetDAO)
        allBudgets = repository.getBudgets()
    }

    fun getBudgets() = repository.getBudgets()

    fun addBudget(budget : Budget) = repository.insertBudget(budget)

    fun updateBudget(budget : Budget) = repository.updateBudget(budget)

    fun deleteBudget(budget: Budget) = repository.deleteBudget(budget)
}