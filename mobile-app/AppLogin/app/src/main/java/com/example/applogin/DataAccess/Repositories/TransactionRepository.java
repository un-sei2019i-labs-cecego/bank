package com.example.applogin.DataAccess.Repositories;

import com.example.applogin.DataAccess.Database.DataBase;
import com.example.applogin.DataAccess.Models.Transaction;

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


    public void createTransaction(String account1, String account2, String type, long amount) {
        database = new DataBase(ctx).getWritableDatabase();
        String hour = "12:00:00";
        String date = "2019-06-01";
        database.execSQL("INSERT INTO transactions (account1, account2, hour, date, type, balance)  " +
                "VALUES ('" +account1 + "', '" + account2 + "','" + hour + "','" + date + "','" + type + "'," + amount + ");");
    }

    public Transaction getTransactionByAccount(String accountId) {
        database = new DataBase(ctx).getWritableDatabase();
        Cursor fila = database.rawQuery("select * from transactions where account1 = '" + accountId + "'", null);
        Transaction transaction = new Transaction(ctx);
        while (fila.moveToNext()) {
            transaction.setId(fila.getInt(fila.getColumnIndex("id")));
            transaction.setAccount1(fila.getString(fila.getColumnIndex("account1")));
            transaction.setAccount2(fila.getString(fila.getColumnIndex("account2")));
            transaction.setTime(fila.getString(fila.getColumnIndex("hour")));
            transaction.setDate(fila.getString(fila.getColumnIndex("date")));
            transaction.setType(fila.getString(fila.getColumnIndex("type")));
            transaction.setBalance(fila.getLong(fila.getColumnIndex("balance")));
        }
        return transaction;
    }

    public Transaction getTransactionById(int id) {
        database = new DataBase(ctx).getWritableDatabase();
        Cursor fila = database.rawQuery("select * from transactions where id = " + id, null);
        Transaction transaction = new Transaction(ctx);
        while (fila.moveToNext()) {
            transaction.setId(fila.getInt(fila.getColumnIndex("id")));
            transaction.setAccount1(fila.getString(fila.getColumnIndex("account1")));
            transaction.setAccount2(fila.getString(fila.getColumnIndex("account2")));
            transaction.setTime(fila.getString(fila.getColumnIndex("hour")));
            transaction.setDate(fila.getString(fila.getColumnIndex("date")));
            transaction.setType(fila.getString(fila.getColumnIndex("type")));
            transaction.setBalance(fila.getLong(fila.getColumnIndex("balance")));

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
