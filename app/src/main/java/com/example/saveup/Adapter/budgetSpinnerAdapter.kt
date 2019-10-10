package com.example.saveup.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.saveup.Model.Budget
import com.example.saveup.R

class budgetSpinnerAdapter(val context : Context, var budgetList : List<Budget>) : BaseAdapter() {
    override fun getItem(position: Int): Any {
        return budgetList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return budgetList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val vh: ItemHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.budget_dropdown_menu, parent, false
            )
            vh = ItemHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }

        vh.lable.text = budgetList[position].budgetName
        vh.budgetSpending.text = budgetList[position].budgetSpending.toString()
        return view
    }

    private class ItemHolder(view : View) {
        val lable : TextView
        val budgetSpending : TextView

        init {
            this.lable = view.findViewById(R.id.dropdownMenuItem) as TextView
            this.budgetSpending = view.findViewById(R.id.budgetSpendingTxt) as TextView
        }
    }
}