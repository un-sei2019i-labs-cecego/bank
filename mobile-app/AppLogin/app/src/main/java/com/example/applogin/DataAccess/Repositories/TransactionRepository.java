package com.example.applogin.DataAccess.Repositories;

import com.example.applogin.DataAccess.Database.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TransactionRepository {

    private SQLiteDatabase database;

    public TransactionRepository(Context ctx) {
        database = new DataBase(ctx).getWritableDatabase();
    }

    private void createTransaction(String account1, String account2, long value) {

       // database.execSQL("update user set " + column + " = '" + value + "' where id = " + id);

    }
}
