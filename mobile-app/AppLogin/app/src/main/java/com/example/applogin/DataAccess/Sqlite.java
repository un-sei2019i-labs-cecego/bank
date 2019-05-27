package com.example.applogin.DataAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite extends SQLiteOpenHelper {

    public Sqlite(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table usuario(identificacion integer primary key, claveNumerica integer)");
        db.execSQL("INSERT INTO usuario (identificacion, claveNumerica) VALUES (1022419092, '123456');");
        db.execSQL("create table administrador(identificacion integer primary key, claveAlfaNumerica text)");
        db.execSQL("INSERT INTO administrador (identificacion, claveNumerica) VALUES (123456789, '123ABC');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists usuario");
        db.execSQL("create table usuario(identificacion integer primary key, claveNumerica integer)");
        db.execSQL("INSERT INTO usuario (identificacion, claveNumerica) VALUES (1022419092, '123456');");
        db.execSQL("drop table if exists administrador");
        db.execSQL("create table administrador(identificacion integer primary key, claveAlfaNumerica text)");
        db.execSQL("INSERT INTO administrador (identificacion, claveNumerica) VALUES (123456789, '123ABC');");

    }

}
