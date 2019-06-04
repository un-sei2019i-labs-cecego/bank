package com.example.applogin.DataAccess.Repositories;

import com.example.applogin.DataAccess.Database.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TransactionRepository {

    private SQLiteDatabase database;
    Context ctx;
    public TransactionRepository(Context ctx) {
        this.ctx = ctx;
    }

    public void createTransaction(int id, String account1, String account2, String hour,
                                  String date, String type, long amount) {
        database = new DataBase(ctx).getWritableDatabase();

        database.execSQL("INSERT INTO transactions (id, account1, account2, hour, date, type, amount)  " +
                "VALUES (" + id + ", '" + account1 + "', '" + account2 + "','" + hour + "','" + date + "','" + type + "'," + amount + ");");
    }

    public boolean transfer(String account1, String account2, long amount) {
        database = new DataBase(ctx).getWritableDatabase();
        String hour="12:00:00";
        //Retirar dinero
        Cursor fila = database.rawQuery("select * from account where account = '" + account1+"'", null);
        Cursor fila2 = database.rawQuery("select * from account where account = '" + account2+"'", null);
        if (fila2.getCount()<1){
            return false;
        }
        long amountOfMoney1;
        while (fila.moveToNext()) {
            amountOfMoney1 = fila.getLong(fila.getColumnIndex("amount"));
            if(amountOfMoney1 - amount<0){
                return false;
            }
            database.execSQL("update account set amount = " + (amountOfMoney1 - amount) + " where account = '" + account1+"'");
        }
        //Ingresar dinero
        long amountOfMoney2;

        while (fila.moveToNext()) {
            amountOfMoney2 = fila2.getLong(fila2.getColumnIndex("amount"));
            database.execSQL("update account set amount = " + (amountOfMoney2 + amount) + " where account = '" + account2+"'");
        }
        return  true;

    }
}
