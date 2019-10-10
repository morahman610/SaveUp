package com.example.saveup.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.saveup.Model.AppDB
import com.example.saveup.Model.Budget
import com.example.saveup.Model.BudgetsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class BudgetViewModel(application: Application) : AndroidViewModel(application) {
    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)
    private lateinit var budgetChosen : Budget

    private val repository : BudgetsRepository
    private val allBudgets : LiveData<List<Budget>>

    init {

        val budgetDAO = AppDB.getDatabase(application, scope).budgetDAO()
        repository = BudgetsRepository(budgetDAO)
        allBudgets = repository.getBudgets()
    }

    fun getBudgets() : LiveData<List<Budget>> = repository.getBudgets()

    fun getAllBudgetNames() : LiveData<List<String>> = repository.getAllBudgetNames()

    fun addBudget(budget : Budget) = scope.launch(Dispatchers.IO) { repository.insertBudget(budget) }

    fun updateBudget(budget : Budget) = scope.launch(Dispatchers.IO) { repository.updateBudget(budget) }

    fun deleteBudget(budget: Budget) = repository.deleteBudget(budget)

    fun getBudget(_budgetName : String) = repository.getBudget(_budgetName)
}