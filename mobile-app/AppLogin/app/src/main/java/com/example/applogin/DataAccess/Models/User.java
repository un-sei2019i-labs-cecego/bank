package com.example.applogin.DataAccess.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applogin.DataAccess.Database.DataBase;

public class User {

    long identificacion;
    long contrasena;

    public User(long identificacion, long contrasena){

        this.identificacion = identificacion;
        this.contrasena = contrasena;

    }

    public boolean verficarContrasena(Context context) {

        DataBase sqlite = new DataBase(context);
        SQLiteDatabase bd = sqlite.getWritableDatabase();
        Cursor fila = bd.rawQuery("select identificacion, claveNumerica from usuario where identificacion = " + identificacion + " and claveNumerica = " + contrasena, null);

        if (fila.moveToFirst()) {

            if (fila.getInt(0) == identificacion && fila.getInt(1) == contrasena) {

                bd.close();
                return true;

            }

        }

        bd.close();
        return false;

    }

}
