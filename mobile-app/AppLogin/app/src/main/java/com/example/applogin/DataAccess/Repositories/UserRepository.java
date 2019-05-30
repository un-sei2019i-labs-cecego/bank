package com.example.applogin.DataAccess.Repositories;

import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;

import android.content.Context;

public class UserRepository {

    private SQLiteDatabase database;

    public UserRepository(Context ctx) {
        database = new DataBase(ctx).getWritableDatabase();
    }

    public void createUser(long id, String name, long phone, String email, String accountNumber, int password) {
        database.execSQL("INSERT INTO usuario (id, name, phone, email, accountNumber, password) " +
                "VALUES (" + id + ", " + name + ", " + phone + ", " + email + ", " + accountNumber + ", " + password + ");");
    }

    public void getUserById() {

    }

    public void updateUser() {

    }

    public void deleteUser() {

    }
}
