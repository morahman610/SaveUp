package com.example.saveup.Model

import androidx.lifecycle.LiveData

class BudgetsRepository(private val budgetDAO: BudgetDAO) {
    companion object {
        @Volatile private var instance: BudgetsRepository? = null

        fun getInstance(budgetDAO: BudgetDAO) = instance?: synchronized(this) {
            instance?: BudgetsRepository(budgetDAO).also { instance = it }
        }
    }

    fun getBudgets() : LiveData<List<Budget>> = budgetDAO.getAllBudgets()
    fun getAllBudgetNames() : LiveData<List<String>> = budgetDAO.getAllBudgetNames()
    fun insertBudget(budget : Budget) = budgetDAO.insertBudget(budget)
    fun deleteBudget(budget: Budget) = budgetDAO.deleteBudget(budget)
    fun deleteAllBudgets() = budgetDAO.deleteAllBudgets()
    fun updateBudget(budget: Budget) = budgetDAO.updateBudget(budget)
}