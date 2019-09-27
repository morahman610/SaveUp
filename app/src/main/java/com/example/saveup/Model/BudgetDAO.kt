package com.example.saveup

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BudgetDAO {

    @Insert
    fun insert(categoryBudget : Budget_Entity)

    @Query("DELETE FROM category_budget_table")
    fun deleteAllBudgets()

    @Query("SELECT * FROM category_budget_table")
    fun getAllBudgets() : LiveData<List<Budget_Entity>>
}