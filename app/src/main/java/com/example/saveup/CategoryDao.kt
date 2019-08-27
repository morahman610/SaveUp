package com.example.saveup

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

interface CategoryDao {

    @Insert
    fun insert(categoryBudget : Category)

    @Query("DELETE FROM category_budget_table")
    fun deleteAllCategories()

    @Query("SELECT * FROM category_budget_table")
    fun getAllCategories() : LiveData<List<Category>>
}