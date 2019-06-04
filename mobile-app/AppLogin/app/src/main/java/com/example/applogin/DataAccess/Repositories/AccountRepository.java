package com.example.applogin.DataAccess.Repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;
import com.example.applogin.DataAccess.Models.Account;

public class AccountRepository {

    private SQLiteDatabase database;
    Context context;
    Account account;

    public AccountRepository(Context context) {
        database = new DataBase(context).getWritableDatabase();
        this.context = context;

    }

    public Account getAccountById(String accountId) {
        database = new DataBase(context).getWritableDatabase();
        Cursor fila = database.rawQuery("select * from account where account = '" + accountId + "'", null);
        account = new Account(context);
        if (fila.getCount() < 1) {
            return null;
        }
        while (fila.moveToNext()) {
            System.out.println("acc -----------------------------");

            account.setAccountNum(fila.getString(fila.getColumnIndex("account")));
            account.setBalance(fila.getLong(fila.getColumnIndex("balance")));
            account.setState(fila.getString(fila.getColumnIndex("state")));
            account.setUserId(fila.getLong(fila.getColumnIndex("userId")));
        }
        return account;
    }

    public void update(String column, String value, String accountId) {
        database = new DataBase(context).getWritableDatabase();
        String hour = "12:00:00";
        database.execSQL("update account set " + column + " = " + value + " where account = '" + accountId + "'");
    }

    public void update(String column, long value, String accountId) {
        database = new DataBase(context).getWritableDatabase();
        String hour = "12:00:00";
        database.execSQL("update account set " + column + " = " + value + " where account = '" + accountId + "'");
    }

    public void delete(String accountId) {
        database.execSQL("delete from user where id = " + accountId);

    }
}
