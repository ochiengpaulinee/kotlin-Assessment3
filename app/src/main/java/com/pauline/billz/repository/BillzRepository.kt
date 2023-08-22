package com.pauline.billz.repository

import com.pauline.billz.BillzApp
import com.pauline.billz.database.BillzDb
import com.pauline.billz.model.Bill
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BillzRepository {
    val db = BillzDb.getDatabase(BillzApp.appContext)
    val billDao = db.billDao()


    suspend fun saveBill(bill: Bill){
        withContext(Dispatchers.IO){
            billDao.insertBill(bill)
        }
    }
}