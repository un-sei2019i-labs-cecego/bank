package com.example.applogin.DataAccess.Repositories;

import com.example.applogin.DataAccess.Database.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TransactionRepository {

    private SQLiteDatabase database;

    public TransactionRepository(Context ctx) {
        database = new DataBase(ctx).getWritableDatabase();
    }

    public void createTransaction(int id, String account1, String account2, String hour,
                                  String date, String type, long amount) {

        database.execSQL("INSERT INTO transactions (id, account1, account2, hour, date, type, amount)  " +
                "VALUES (" + id + ", '" + account1 + "', '" + account2 + "','" + hour + "','" + date + "','" + type + "'," + amount + ");");
    }

    public void transfer(String account1, String account2, String hour, long amount) {
        //Retirar dinero
        Cursor fila = database.rawQuery("select * from account where account = '" + account1+"'", null);
        long amountOfMoney1;
        ContentValues cv = new ContentValues();
        while (fila.moveToNext()) {
            amountOfMoney1 = fila.getLong(fila.getColumnIndex("amount"));
            cv.put("amount",(amountOfMoney1 - amount)+"");
            database.update("account",cv,"account = '" + account1+"'",null);
            //database.execSQL("update account set amount = " + (amountOfMoney1 - amount) + " where account = '" + account1+"'");
        }
        //Ingresar dinero
        fila = database.rawQuery("select * from account where account = '" + account2+"'", null);
        long amountOfMoney2;
        while (fila.moveToNext()) {
            amountOfMoney2 = fila.getLong(fila.getColumnIndex("amount"));
            cv.put("amount",(amountOfMoney2 - amount)+"");
            database.update("account",cv,"account = '" + account2+"'",null);
            //database.execSQL("update account set amount = " + (amountOfMoney2 + amount) + " where account = '" + account2+"'");
        }


    }
}
