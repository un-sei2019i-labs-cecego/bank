package com.example.applogin.DataAccess.Repositories;

import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;
import com.example.applogin.DataAccess.Models.User;

import android.content.Context;
import android.database.Cursor;


public class UserRepository {

    private SQLiteDatabase database;
    Context context;
    public UserRepository(Context ctx) {
        //ctx.deleteDatabase("DB");
        context = ctx;
        database = new DataBase(ctx).getWritableDatabase();
    }

    public void createUser(long id, String name, long phone, String email, String accountNumber, long password) {
        database.execSQL("INSERT INTO user (id, name, phone, email, accountNumber, password) " +
                "VALUES (" + id + ", " + name + ", " + phone + ", " + email + ", " + accountNumber + ", " + password + ");");
    }

    public User getUserById(long id) {
        User user = new User(context);
        Cursor fila = database.rawQuery("select * from user where id = " + id, null);
        while (fila.moveToNext()) {
            user.setId(fila.getLong(fila.getColumnIndex("id"));
            user.setName(fila.getString(fila.getColumnIndex("name"));
            user.setPhone(fila.getLong(fila.getColumnIndex("phone"));
            user.setEmail(fila.getString(fila.getColumnIndex("email"));
            user.setAccountNumber(fila.getString(fila.getColumnIndex("accountNumber"));
            user.setPassword(fila.getLong(fila.getColumnIndex("password"));
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
