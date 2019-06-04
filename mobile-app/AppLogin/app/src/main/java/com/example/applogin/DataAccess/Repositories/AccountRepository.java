package com.example.applogin.DataAccess.Repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;

public class AccountRepository {

    private SQLiteDatabase database;

    public AccountRepository(Context ctx) {
        database = new DataBase(ctx).getWritableDatabase();
    }

    public Object[] getAccountById(String account) {
        Object user[] = new Object[3];
        Cursor fila = database.rawQuery("select * from account where account = '" + account + "'", null);
        while (fila.moveToNext()) {
            user[0] = fila.getString(fila.getColumnIndex("account"));
            user[1] = fila.getLong(fila.getColumnIndex("amount"));
            user[2] = fila.getString(fila.getColumnIndex("state"));
        }
        return user;
    }

}
