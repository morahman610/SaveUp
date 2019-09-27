package com.example.saveup.Utils

import com.example.saveup.Model.AppDB
import com.example.saveup.Model.BudgetsRepository
import com.example.saveup.ViewModel.ViewModelFactory

class InjectorUtils {

    fun provideBudgetViewModelFactory() : ViewModelFactory {
        val budgetsRepository = BudgetsRepository(AppDB.getDatabase())
    }
}