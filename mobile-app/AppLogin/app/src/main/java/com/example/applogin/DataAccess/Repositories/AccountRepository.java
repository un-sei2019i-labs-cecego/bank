package com.example.applogin.DataAccess.Repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;

public class AccountRepository {

    private SQLiteDatabase database;
    Context ctx;

    public AccountRepository(Context ctx) {
        database = new DataBase(ctx).getWritableDatabase();
        this.ctx = ctx;

    }

    public Object[] getAccountById(String accountId) {
        database = new DataBase(ctx).getWritableDatabase();
        Cursor fila = database.rawQuery("select * from account where account = '" + accountId + "'", null);
        Object account[] = new Object[4];
        while (fila.moveToNext()) {
            account[0] = fila.getLong(fila.getColumnIndex("account"));
            account[1] = fila.getString(fila.getColumnIndex("amount"));
            account[2] = fila.getLong(fila.getColumnIndex("state"));
            account[3] = fila.getString(fila.getColumnIndex("id"));
        }
        return account;
    }

    public void update(String column, String value, String accountId) {
        database = new DataBase(ctx).getWritableDatabase();
        String hour = "12:00:00";
        database.execSQL("update account set " + column + " = " + value + " where account = '" + accountId + "'");
    }

    public void update(String column, long value, String accountId) {
        database = new DataBase(ctx).getWritableDatabase();
        String hour = "12:00:00";
        database.execSQL("update account set " + column + " = " + value + " where account = '" + accountId + "'");
    }

    public void delete(String accountId) {
        database.execSQL("delete from user where id = " + accountId);

    }
}
