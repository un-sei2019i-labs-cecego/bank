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
        db.execSQL("INSERT INTO user (id, name, phone, email, accountNumber, password)  VALUES (1013681625, 'Gonzalo Diaz', 3134340058,'gonzalo@gmail.com','1234-5678-9999-1111', 123456);");
        db.execSQL("INSERT INTO user (id, name, phone, email, accountNumber, password)  VALUES (1032494428, 'David Pineda', 3166226220,'cdpinedao@gmail.com','1234-5678-9999-2222', 123456);");
        db.execSQL("INSERT INTO user (id, name, phone, email, accountNumber, password)  VALUES (1022419092, 'Cesar torres', 3102112394,'cesar@gmail.com','1234-5678-9999-3333', 123456);");
        db.execSQL("create table admin(id integer primary key, name text, phone bigint, email text, password integer)");
        db.execSQL("INSERT INTO admin (id, name, phone, email, password)  VALUES (1013681625, 'Gonzalo Diaz', 3134340058,'gonzalo@gmail.com', 123456);");
        db.execSQL("create table transactions(id integer primary key autoincrement, account1 text, account2 text, hour text, date text,type text, balance bigint)");
        db.execSQL("create table account(account text primary key, balance bigint, state text, userId integer, foreign key(userId) references user (id))");
        db.execSQL("INSERT INTO account (account, balance, state,userId)  VALUES ('1234-5678-9999-1111', 100000, 'Activada',1013681625);");
        db.execSQL("INSERT INTO account (account, balance, state,userId)  VALUES ('1234-5678-9999-2222', 100000, 'Activada',1032494428);");
        db.execSQL("INSERT INTO account (account, balance, state,userId)  VALUES ('1234-5678-9999-3333', 100000, 'Activada',1022419092);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

}
