package com.pauline.billz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauline.billz.model.Bill
import com.pauline.billz.repository.BillzRepository
import kotlinx.coroutines.launch

class BillzViewModel:ViewModel() {
    var billsRepo = BillzRepository()

     fun saveBill(bill: Bill){
         viewModelScope.launch {
             billsRepo.saveBill(bill)
         }
     }
}