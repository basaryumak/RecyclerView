package com.example.recyclerview.data

import android.content.Context
import com.example.recyclerview.R
import com.example.recyclerview.model.Worker

class DataSource(val context: Context) {
    fun getWorkerNamesList(): Array<String>{
        return context.resources.getStringArray(R.array.name_array)
    }
    fun getWorkerCompanyList(): Array<String>{
        return context.resources.getStringArray(R.array.company_array)
    }
    fun getWorkerSsnList(): Array<String>{
        return context.resources.getStringArray(R.array.ssn_array)
    }

    fun loadUsers(): List<Worker>{
        val namesList = getWorkerNamesList()
        val companyList = getWorkerCompanyList()
        val ssnList  = getWorkerSsnList()

        val workers = mutableListOf<Worker>()
        for (i in namesList.indices){
            workers.add(Worker(namesList[i], company = companyList[i], ssn = ssnList[i]))
        }
        return workers
    }
}