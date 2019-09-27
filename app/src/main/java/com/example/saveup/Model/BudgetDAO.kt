package com.example.saveup.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BudgetDAO {

    @Query("DELETE FROM category_budget_table")
    fun deleteAllBudgets()

    @Delete
    fun deleteBudget(budget: Budget)

    @Query("SELECT * FROM category_budget_table")
    fun getAllBudgets() : LiveData<List<Budget>>

    @Insert
    fun insertBudget(budget : Budget)

    @Update
    fun updateBudget(budget: Budget)
}