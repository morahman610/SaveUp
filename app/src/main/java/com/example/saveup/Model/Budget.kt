package com.example.saveup.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_budget_table")
class Budget (
    val budgetName :String,
    val budgetSpending : Int = 0,
    val budgetMaxSpending : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}