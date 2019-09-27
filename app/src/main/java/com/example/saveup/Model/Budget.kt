package com.example.saveup.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_budget_table")
class Budget (
    private var categoryID : Int,
    private var categoryName :String,
    private var categorySpending : Int,
    private var categoryMaxSpending : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}