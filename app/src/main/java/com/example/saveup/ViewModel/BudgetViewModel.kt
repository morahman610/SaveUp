package com.example.saveup

import androidx.lifecycle.ViewModel
import com.example.saveup.Model.Budget_Entity
import com.example.saveup.Model.BudgetsRepository

class BudgetViewModel(val budgetsRepository: BudgetsRepository) : ViewModel() {

    fun getBudgets() = budgetsRepository.getBudgets()

    fun addPlace(budget : Budget_Entity) = budgetsRepository.insertBudget(budget)
}