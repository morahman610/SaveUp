package com.example.saveup.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_budget_table")
class Budget (
    var budgetName :String,
    var budgetSpending : Int = 0,
    var budgetMaxSpending : Int
) {
    @PrimaryKey(autoGenerate = true)
    var budgetID : Int = 0
}