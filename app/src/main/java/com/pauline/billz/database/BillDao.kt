package com.pauline.billz.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.pauline.billz.model.Bill

@Dao
interface BillDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBill(bill: Bill)
}