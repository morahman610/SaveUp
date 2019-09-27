package com.example.saveup.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.saveup.Model.BudgetsRepository

class ViewModelFactory(private val budgetsRepository: BudgetsRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BudgetViewModel(budgetsRepository) as T
    }
}