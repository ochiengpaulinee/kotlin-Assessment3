package com.pauline.billz.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pauline.billz.model.Bill

@Database(entities = [Bill::class], version = 1)
abstract class BillzDb:RoomDatabase() {
    abstract fun billDao():BillDao

    companion object{
        var database:BillzDb? = null

        fun getDatabase(context: Context):BillzDb{
            if(database==null){
                database = Room.databaseBuilder(context, BillzDb::class.java, name = "BillzDb")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as BillzDb
        }
    }
}