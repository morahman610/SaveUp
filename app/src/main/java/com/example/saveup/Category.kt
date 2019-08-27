package com.example.saveup

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_budget_table")
class Category  (
    var categoryID : Int,
    var categoryName :String,
    var categorySpending : Int,
    var categoryMaxSpending : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}