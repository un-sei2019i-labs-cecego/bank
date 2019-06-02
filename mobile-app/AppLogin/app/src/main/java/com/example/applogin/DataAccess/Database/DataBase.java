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
        db.execSQL("create table transactions(id integer primary key autoincrement, account1 text, account2 text, hour text, date text,type text, amount bigint)");
        db.execSQL("INSERT INTO transactions (account1, account2, hour, date,type, amount)  VALUES ('1231-4141-1414-8787', '4568-9841-1223-1313', '10:30:26','2019-10-15', 100000);");
        db.execSQL("create table account(account text primary key, amount bigint, state text)");
        db.execSQL("INSERT INTO account (account, amount, state)  VALUES ('1231-4141-1414-8787', '100000', 'Aceptada');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("create table user(id integer primary key, name text, phone bigint, email text, accountNumber text,  password integer)");
        db.execSQL("INSERT INTO user (id, name, phone, email, accountNumber, password)  VALUES (1013681625, 'Gonzalo Diaz', 3134340058,'gonzalo@gmail.com','1235-4654-3213-6546', 123456);");
        db.execSQL("create table admin(id integer primary key, name text, phone bigint, email text, password integer)");
        db.execSQL("INSERT INTO admin (id, name, phone, email, password)  VALUES (1013681625, 'Gonzalo Diaz', 3134340058,'gonzalo@gmail.com', 123456);");
        db.execSQL("create table transactions(id integer primary key autoincrement, account1 text, account2 text, hour text, date text,type text, amount bigint)");
        db.execSQL("INSERT INTO transactions (account1, account2, hour, date,type, amount)  VALUES ('1231-4141-1414-8787', '4568-9841-1223-1313', '10:30:26','2019-10-15', 100000);");
        db.execSQL("create table account(account text primary key, amount bigint, state text)");
        db.execSQL("INSERT INTO account (account, amount, state)  VALUES ('1231-4141-1414-8787', '100000', 'Aceptada');");
    }

}
