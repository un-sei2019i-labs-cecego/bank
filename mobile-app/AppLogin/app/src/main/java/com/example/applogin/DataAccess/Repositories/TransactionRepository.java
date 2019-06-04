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


    public boolean transfer(String account1, String account2, long amount) {
        database = new DataBase(ctx).getWritableDatabase();
        String hour = "12:00:00";
        //Retirar dinero
        Cursor fila = database.rawQuery("select * from account where account = '" + account1 + "'", null);
        Cursor fila2 = database.rawQuery("select * from account where account = '" + account2 + "'", null);
        if (fila2.getCount() < 1) {
            return false;
        }
        long amountOfMoney1;
        while (fila.moveToNext()) {
            amountOfMoney1 = fila.getLong(fila.getColumnIndex("amount"));
            if (amountOfMoney1 - amount < 0) {
                return false;
            }
            database.execSQL("update account set amount = " + (amountOfMoney1 - amount) + " where account = '" + account1 + "'");
        }
        //Ingresar dinero
        long amountOfMoney2;

        while (fila.moveToNext()) {
            amountOfMoney2 = fila2.getLong(fila2.getColumnIndex("amount"));
            database.execSQL("update account set amount = " + (amountOfMoney2 + amount) + " where account = '" + account2 + "'");
        }
        return true;

    }

    public void createTransaction(int id, String account1, String account2, String hour,
                       String date, String type, long amount) {
        database = new DataBase(ctx).getWritableDatabase();

        database.execSQL("INSERT INTO transactions (id, account1, account2, hour, date, type, amount)  " +
                "VALUES (" + id + ", '" + account1 + "', '" + account2 + "','" + hour + "','" + date + "','" + type + "'," + amount + ");");
    }

    public void getTransactionByAccount(String accountId) {
        database = new DataBase(ctx).getWritableDatabase();
        Cursor fila = database.rawQuery("select * from transactions where account1 = '" + accountId + "'", null);
        Object transaction[] = new Object[4];
        while (fila.moveToNext()) {
            transaction[0] = fila.getLong(fila.getColumnIndex("id"));
            transaction[1] = fila.getString(fila.getColumnIndex("account1"));
            transaction[2] = fila.getLong(fila.getColumnIndex("account2"));
            transaction[3] = fila.getString(fila.getColumnIndex("hour"));
            transaction[4] = fila.getString(fila.getColumnIndex("date"));
            transaction[5] = fila.getString(fila.getColumnIndex("type"));
            transaction[6] = fila.getString(fila.getColumnIndex("amount"));

        }
    }
    public Object[] getTransactionById(int id) {
        database = new DataBase(ctx).getWritableDatabase();
        Cursor fila = database.rawQuery("select * from transactions where id = " +id, null);
        Object transaction[] = new Object[4];
        while (fila.moveToNext()) {
            transaction[0] = fila.getLong(fila.getColumnIndex("id"));
            transaction[1] = fila.getString(fila.getColumnIndex("account1"));
            transaction[2] = fila.getLong(fila.getColumnIndex("account2"));
            transaction[3] = fila.getString(fila.getColumnIndex("hour"));
            transaction[4] = fila.getString(fila.getColumnIndex("date"));
            transaction[5] = fila.getString(fila.getColumnIndex("type"));
            transaction[6] = fila.getString(fila.getColumnIndex("amount"));

        }
        return transaction;
    }
    public void update(String column, String value, String transactionId) {
        database = new DataBase(ctx).getWritableDatabase();
        String hour = "12:00:00";
        database.execSQL("update transactions set " + column + " = " + value + " where id = " + transactionId);
    }

    public void update(String column, long value, String transactionId) {
        database = new DataBase(ctx).getWritableDatabase();
        String hour = "12:00:00";
        database.execSQL("update transactions set " + column + " = " + value + " where id = " + transactionId);
    }

    public void delete(String transactionId) {
        database.execSQL("delete from transactions where id = " + transactionId);

    }
}
