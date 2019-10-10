package com.example.saveup.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BudgetDAO {

    @Query("SELECT * FROM category_budget_table")
    fun getAllBudgets() : LiveData<List<Budget>>

    @Query("SELECT budgetName FROM category_budget_table")
    fun getAllBudgetNames() : LiveData<List<String>>

    @Query("SELECT * FROM category_budget_table WHERE budgetName == :budgetName")
    fun getBudget(budgetName : String) : Budget

    @Insert
    fun insertBudget(budget : Budget)

    @Update
    fun updateBudget(budget: Budget)

    @Query("DELETE FROM category_budget_table")
    fun deleteAllBudgets()

    @Delete
    fun deleteBudget(budget: Budget)
}