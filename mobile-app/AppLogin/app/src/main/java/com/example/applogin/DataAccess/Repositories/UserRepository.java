package com.example.applogin.DataAccess.Repositories;

import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;

import android.content.Context;
import android.database.Cursor;


public class UserRepository {

    private SQLiteDatabase database;

    public UserRepository(Context ctx) {
        ctx.deleteDatabase("DB");
        database = new DataBase(ctx).getWritableDatabase();
    }

    public void createUser(long id, String name, long phone, String email, String accountNumber, long password) {
        database.execSQL("INSERT INTO user (id, name, phone, email, accountNumber, password) " +
                "VALUES (" + id + ", " + name + ", " + phone + ", " + email + ", " + accountNumber + ", " + password + ");");
    }

    public Object[] getUserById(long id) {
        Object user[] = new Object[6];
        Cursor fila = database.rawQuery("select * from user where id = " + id, null);
        while (fila.moveToNext()) {
            user[0] = fila.getLong(fila.getColumnIndex("id"));
            user[1] = fila.getString(fila.getColumnIndex("name"));
            user[2] = fila.getLong(fila.getColumnIndex("phone"));
            user[3] = fila.getString(fila.getColumnIndex("email"));
            user[4] = fila.getString(fila.getColumnIndex("accountNumber"));
            user[5] = fila.getLong(fila.getColumnIndex("password"));
        }
        return user;
    }

    public void updateUser(String column, String value, long id) {
        database.execSQL("update user set " + column + " = '" + value + "' where id = "+id);

    }

    public void updateUser(String column, int value, long id) {
        database.execSQL("update user set " + column + " = " + value + " where id = "+id);

    }

    public void deleteUser(long id) {
        database.execSQL("delete from user where id = "+id);

    }
}
