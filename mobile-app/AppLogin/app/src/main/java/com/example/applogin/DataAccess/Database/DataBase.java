package com.example.applogin.DataAccess.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {

        super(context, "DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table user(id integer primary key, name text, phone bigint, email text, accountNumber text,  password integer)");
        db.execSQL("INSERT INTO user (id, name, phone, email, accountNumber, password)  VALUES (1013681625, 'Gonzalo Diaz', 3134340058,'gonzalo@gmail.com','1235-4654-3213-6546', 123456);");
        db.execSQL("create table admin(id integer primary key, name text, phone bigint, email text, password integer)");
        db.execSQL("INSERT INTO admin (id, name, phone, email, password)  VALUES (1013681625, 'Gonzalo Diaz', 3134340058,'gonzalo@gmail.com', 123456);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("create table user(id integer primary key, name text, phone bigint, email text, accountNumber text,  password integer)");
        db.execSQL("INSERT INTO user (id, name, phone, email, accountNumber, password)  VALUES (1013681625, 'Gonzalo Diaz', 3134340058,'gonzalo@gmail.com','1235-4654-3213-6546', 123456);");
        db.execSQL("create table admin(id integer primary key, name text, phone bigint, email text, password integer)");
        db.execSQL("INSERT INTO admin (id, name, phone, email, password)  VALUES (1013681625, 'Gonzalo Diaz', 3134340058,'gonzalo@gmail.com', 123456);");

    }

}
