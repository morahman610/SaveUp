package com.example.saveup

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(Budget_Entity::class)], version = 1)
abstract class AppDB : RoomDatabase()  {

    abstract class budgetDAO : BudgetDAO
}